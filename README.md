# registry-service

Annuaire de services (Service Discovery) de la plateforme **DREAMHOUSE237**, basé sur **Netflix Eureka** (Spring Cloud).

## Rôle

Permet à chaque microservice de s'enregistrer au démarrage et de découvrir dynamiquement les instances actives des autres services, sans adresses IP codées en dur. `proxy-service` s'appuie sur ce registre pour répartir le trafic (load-balancing) vers les instances saines de chaque service.

## Stack

- Java / Spring Boot / Spring Cloud Netflix Eureka Server
- Port interne `8761` (console web Eureka accessible sur ce port)

## Architecture

C'est l'un des deux services d'infrastructure "socle" de la plateforme (avec `config-service`), démarré en premier. Tous les autres microservices déclarent son URL (`eureka.client.service-url.defaultZone`) dans leur configuration pour s'y enregistrer et envoyer un heartbeat périodique.

## Développement local

```bash
./mvnw spring-boot:run
```

Console disponible sur `http://localhost:8761`.

## Déploiement

Via **Docker Swarm** (voir [`infrastructure`](https://github.com/DREAMHOUSE-237/infrastructure)). Contrairement aux autres services, un redémarrage de `registry-service` impacte temporairement toute la plateforme (les autres services perdent leur enregistrement le temps de se ré-enregistrer) — à traiter avec précaution en production.
