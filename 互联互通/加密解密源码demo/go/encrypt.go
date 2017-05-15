package encrypt

import (
	"bytes"
	"crypto/aes"
	"crypto/cipher"
	"crypto/hmac"
	"crypto/md5"
	b64 "encoding/base64"
	"encoding/hex"
	"fmt"
	"time"
)

type JsonData struct {
	OperatorID string `json:"OperatorID"`
	Data       string `json:"Data"`
	TimeStamp  string `json:"TimeStamp"`
	Sig        string `json:"Sig"`
}

func AesEncrypt(s string, key []byte, iv []byte) (string, error) {
	origData := []byte(s)
	block, err := aes.NewCipher(key)
	if err != nil {
		return "", err
	}
	blockSize := block.BlockSize()
	origData = PKCS5Padding(origData, blockSize)
	blockMode := cipher.NewCBCEncrypter(block, iv)
	crypted := make([]byte, len(origData))
	blockMode.CryptBlocks(crypted, origData)
	return b64.StdEncoding.EncodeToString(crypted), nil
}

func AesDecrypt(s string, key []byte, iv []byte) ([]byte, error) {
	b64decodeStr, err := b64.StdEncoding.DecodeString(s)
	if err != nil {
		return nil, err
	}
	block, err := aes.NewCipher(key)
	if err != nil {
		return nil, err
	}
	//blockSize := block.BlockSize()
	blockMode := cipher.NewCBCDecrypter(block, iv)
	origData := make([]byte, len(b64decodeStr))
	// origData := crypted
	blockMode.CryptBlocks(origData, b64decodeStr)
	origData = PKCS5UnPadding(origData)
	return origData, nil
}

func PKCS5Padding(ciphertext []byte, blockSize int) []byte {
	padding := blockSize - len(ciphertext)%blockSize
	padtext := bytes.Repeat([]byte{byte(padding)}, padding)
	return append(ciphertext, padtext...)
}

func PKCS5UnPadding(origData []byte) []byte {
	length := len(origData)
	// remove the last byte
	unpadding := int(origData[length-1])
	return origData[:(length - unpadding)]
}

func ToTime(t int64) string {
	to := time.Unix(t, 0)
	return to.Format("20060102150405")
}

func MakeSign(jsonObj *JsonData, key []byte) string {
	url := fmt.Sprintf("OperatorId=%s&Data=%s&TimeStamp=%s", jsonObj.OperatorID, jsonObj.Data, jsonObj.TimeStamp)
	h := hmac.New(md5.New, key)
	h.Write([]byte(url))
	return hex.EncodeToString(h.Sum(nil))
}

func MakeSignBody(operatorId string, data string, t string, key []byte) *JsonData {
	s := new(JsonData)
	s.OperatorID = operatorId
	s.Data = data
	s.TimeStamp = t
	s.Sig = MakeSign(s, key)
	return s
}

func CheckSignWithBody(jsonObj *JsonData, key []byte) bool {
	return MakeSign(jsonObj, key) == jsonObj.Sig
}
