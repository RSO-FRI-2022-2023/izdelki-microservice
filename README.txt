

NALOGA 5
docker command 
docker run -d -p 8500:8500 -p 8600:8600/udp --name=badger consul agent -server -bootstrap-expect=1 -ui -node=server-1 -client=0.0.0.0

consul ui localhost:8500

KEY: environments/dev/services/izdelki-service/1.0.0/config/rest-properties/discount


Konfiguracija:
datasource username, password -> config file (enak za vsa izvajalna okolja)
connection-url: okoliške spremenljivke za vsako izvajalno okolje posebaj
discount: hierarhija: default false(config file), config strežnik za spreminjanje med izvajanjem


NALOGA 6
http://localhost:8080/health
http://localhost:8080/health/live
http://localhost:8080/health/ready
http://localhost:8080/health/break
http://localhost:8080/health/repair


GET http://localhost:8080/v1/trgovine/najblizja/46.0504235/14.4562298 
vrne najblizjo trgovino
