# Property Inspection

A local-first property inspection app built with Spring Boot and React.

## Requirements

- Java 25
- Maven 3.9 or newer
- Node.js 24 and pnpm 11

## Run locally

Start the backend from the repository root:

```powershell
mvn -f backend/pom.xml spring-boot:run
```

In a second terminal, install and start the frontend:

```powershell
pnpm install
pnpm --filter property-inspection-frontend dev
```

Open <http://localhost:5173>. The backend health endpoint is <http://localhost:8080/actuator/health>.

## Checks

From the repository root:

```powershell
mvn -B -f backend/pom.xml verify
pnpm install --frozen-lockfile
pnpm --filter property-inspection-frontend test -- --run
pnpm --filter property-inspection-frontend build
```

GitHub Actions runs the backend and frontend checks for every pull request and every push to `main`.
