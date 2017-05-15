# -*- coding: utf-8 -*-
from Crypto.Cipher import AES
import base64

key = b'1234567890abcdef'
text = 'hello world!'
IV = b'1234567890abcdef'


BS = AES.block_size
pad = lambda s: s + (BS - len(s) % BS) * chr(BS - len(s) % BS)

cipher = AES.new(key, AES.MODE_CBC, IV=IV)
encrypted = cipher.encrypt(pad(text))
result = base64.b64encode(encrypted)
print result 

unpad = lambda s : s[0:-ord(s[-1])]
cipher = AES.new(key, AES.MODE_CBC, IV=IV)
result2 = base64.b64decode(result)
decrypted = unpad(cipher.decrypt(result2))
print decrypted 