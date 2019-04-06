# mutual-auth
Mutual auth rest api project using x509, pcs12 and trust &amp; key stores

Client --> establishes trust via client trustore (server pem(x509))
Server --> establishes trust via server keystore (server pem(x509) server cert)
