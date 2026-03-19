# IoT Security Evaluation JavaFX Module

This module adds a JavaFX desktop app skeleton that mirrors the 3-tier architecture in your final year project report:

- `ui` (presentation)
- `core` (business logic)
- `data` (data access/models)
- `util` (shared configuration)

## How it connects to your existing repository

- MQTT listener subscribes to `iot/#`, matching `logger/mqtt_logger.py`.
- SQLite config points at `../security/security_metrics.db`, matching your Python benchmark scripts.
- Evaluation engine provides FR4–FR7 style scoring flow for security, energy, and affordability.

## Run

From this folder:

```bash
mvn javafx:run
```

Compile only:

```bash
mvn -q -DskipTests compile
```
