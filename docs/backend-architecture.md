# Backend architecture

## Decision

The backend uses a small, explicit hexagonal structure with application, domain, and infrastructure packages. Package names describe the role of code; technology-specific details stay at the infrastructure edge.

Repository ports belong to the domain. This follows the domain ownership of the contracts that persistence adapters implement.

## Package responsibilities

| Package | Responsibility | Examples |
| --- | --- | --- |
| `com.propertyinspection.application` | Application use cases and workflow orchestration | `GetCustomers`, commands and queries |
| `com.propertyinspection.domain` | Business model, rules, domain services, and repository ports | Customer and inspection concepts; repository interfaces |
| `com.propertyinspection.infrastructure` | Framework and external-system adapters | Web controllers, persistence adapters, messaging adapters, Spring Boot startup |

The repository currently has no business use cases or domain model. The `package-info.java` files establish the package boundaries without inventing placeholder business types.

## Dependency rules

Dependencies point inward:

- Domain code depends only on the domain and standard Java types. It does not depend on Spring, JPA, web libraries, or infrastructure.
- Application use cases may depend on domain types and ports, but not infrastructure adapters.
- Infrastructure adapters may depend on application use cases and domain ports.
- Inbound adapters, such as REST controllers, translate external requests and responses and call use cases. They do not contain business workflows.
- Outbound adapters, such as persistence implementations, implement the domain-owned ports.

When the first use case is introduced, name the class for its business action (for example, `GetCustomers`) and implement the shared `UseCase` contract. Define that contract with the first real use case so its input and output types fit an actual workflow.

## Application startup

`PropertyInspectionApplication` lives in `com.propertyinspection.infrastructure`. Since that package is narrower than the application's root package, the Spring Boot entry point explicitly scans `com.propertyinspection`. This keeps application, domain, and infrastructure components discoverable.

## Tests

- Unit tests belong with the layer or package whose behavior they describe.
- Cucumber scenarios under `backend/src/test/resources/features` document observable application behavior through an integration boundary.
- Architecture changes must preserve existing behavior and keep `mvn -B -f backend/pom.xml verify` green.
