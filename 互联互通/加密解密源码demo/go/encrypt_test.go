package encrypt

import "testing"

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
