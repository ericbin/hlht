package encrypt

import (
	"testing"
	"fmt"
)

/*func main() {
	TestCBCAES()
}*/
var key = []byte("1234567890abcdef")
var iv = []byte("1234567890abcdef")
var signKey = []byte("key")
var ok = &JsonData{
	Data:       "rWw+eGNoGIT9QTHun71Efg==",
	OperatorID: "1",
	Sig:        "9abdbba388a6a862eb74c3adb91d7352",
	TimeStamp:  "20160728231909",
}

func TestCBCAES(t *testing.T) {
	// AES encryption
	// Key length: 16, 24, 32 bytes => AES-128, AES-192, AES-256

	result, err := AesEncrypt("hello world!", key, iv)
	if err != nil {
		panic(err)
	}
	if result != "cmljobIKHDAcF9uf3mgs/w==" {
		t.Error("encrypt error")
	}
	origData, err := AesDecrypt(result, key, iv)
	if err != nil {
		panic(err)
	}
	if string(origData) != "hello world!" {
		t.Error("decrypt error")
	}
}

func TestMakeSignBody(t *testing.T) {
	s := MakeSignBody(ok.OperatorID, ok.Data, ok.TimeStamp, signKey)
	if ok.Sig != s.Sig {
		t.Error("make sign body error")
	}
}

func TestCheckSignWithBody(t *testing.T) {
	if CheckSignWithBody(ok, []byte("aa")) == true {
		t.Error("check sign error")
	}

	if CheckSignWithBody(ok, signKey) == false {
		t.Error("check sign error")
	}
}



func TestCBCDEC(t *testing.T) {
	// AES encryption
	// Key length: 16, 24, 32 bytes => AES-128, AES-192, AES-256

	s:= `X6j5yLBjFJIUuR/iC32nO9B05cUsNBby7FOwv1nfGUWGiq+Sj/GrnRaahYanSihydALbqnPNrsc8\nRZmfKKSU1vOZh2JrrOibvDGEuhgZ4zJEZ/oqD1N7QvPhyam5PqeGsJzbEsa0Q+MQDC2dKhBgxF2Q\n9Oe1S7VaZc599s3i93K0Om1OH+mvnH1e0hUB2itNnY/GO7qSREwmclfaplaEuvWjfg7vZkRtOtmA\ngoh9FW666q+AfG2X4KnjG19Ta9cpnXlWCuzbzqmEMOhdNnquWoOi9lHcghdgW2njReDV8WO+cItI\nODyBIlKJcBEJgtXIpv2i0KDBXeCv/zVYRvDXIKIznlQ1W3PzwYpyV6kEpGX131iaXnOpSY0E7HUC\nw3nAbb06JIRN6zPc1iBNoLlkdLNFBMdtq9/SEarXZqgayxcOpSp3teYlOdMIF4+MvRDPoM9Cjc3L\nwOfSM0IoyXLMDfoL5Ch9QU5Qtrxyq+GHx/3mUYMycRUzNa7e3p2lIpP9p/8qw95GfI1oj/qsPwZ5\nlQ=="`

	fmt.Println(AesDecrypt(s, key, iv))

}