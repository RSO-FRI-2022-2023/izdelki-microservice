https://www.songify.si/rso/izdelki/v1/izdelki

NALOGA 5
docker command 
docker run -d -p 8500:8500 -p 8600:8600/udp --name=badger consul agent -server -bootstrap-expect=1 -ui -node=server-1 -client=0.0.0.0

consul ui localhost:8500

KEY: environments/dev/services/izdelki-service/1.0.0/config/rest-properties/discount


Konfiguracija:
datasource username, password -> config file (enak za vsa izvajalna okolja)
connection-url: okoliške spremenljivke za vsako izvajalno okolje posebej
discount: hierarhija: default false(config file), config strežnik za spreminjanje med izvajanjem
broken: v config file -> namenjeno za simuliranje health checkov in auto restart poda

LOKALNO:
http://localhost:8500/
Ročna sprememba DISCOUNT spremenljivke ali
POST http://localhost:8080/v1/discount/discount - menjava discount vrednosti 0 in 0.1
http://localhost:8080/v1/izdelki


NALOGA 6
http://localhost:8080/health
http://localhost:8080/health/live
http://localhost:8080/health/ready
http://localhost:8080/health/break
http://localhost:8080/health/repair


https://www.songify.si/rso/izdelki/health

POST KLIC https://www.songify.si/rso/izdelki/health/break

metrics
https://www.songify.si/rso/izdelki/metrics


GET http://localhost:8080/v1/trgovine/najblizja/46.0504235/14.4562298 
vrne najblizjo trgovino


VAJA 7
V grafani
marker.name: ENTRY
contextMap.applicationName: "priljubljeni-izdelki-service"
contextMap.applicationName: "izdelki-service"
contextMap.method: vrniIzdelke

contextMap.applicationName:"priljubljeni-izdelki-service" AND level:"INFO"

KAKO DEMONSTRACIJA SLEDENJE ZAHTEVKOV NA RAZLICNIH MIKROSTORITVAH- pri kosaricah ???
NUJNO DODAJ CENTRALNO BELEZENJE Z INTERCEPTORJEM NA VSE STORITVE.


Vaja 8
Fault tolerance ....
Asinhroni klic v izdelek resource
Pridobitev priljubljenih izdelkov na asinhron način.
POST KLIC https://www.songify.si/rso/izdelki/v1/izdelki/priljubljeni
Glej LOGE...


VAJA 9
graphql
http://localhost:8080/graphiql

query MyQuery {
  izdelek(id: 1) {
    id
    kategorija
    naziv
  }
}


query MyQuery {
  izdelke {
    id
    kategorija
    naziv
    cene {
      cena
      discount
      id
      izdelek {
        id
        kategorija
        naziv
      }
      trgovina {
        id
        ime
        longitude
        latitude
        lokacija
      }
    }
  }
}

mutation MyMutation {
  deleteImageMetadata(id: 1) {
    deleted
  }
}

