# Prototype project to learn Github Actions

## Pull dependencies

```bash
./mvnw dependency:resolve
```

## Build artifact with workspace clean before and -U to clear cache.

```bash
./mvnw -U clean install
```

## Run application

```bash
java -jar target/${artifactId}-${version}.jar
```

## Adjust application properties