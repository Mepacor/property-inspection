# Agent instructions

## General

- Keep changes focused on the assigned issue. Inspect relevant files and follow the existing project conventions.
- Prefer clear, cohesive code. Apply DDD and SOLID where they fit; avoid god methods, unnecessary abstractions, and overengineering.
- Do not add dependencies, integrations, or features unless the issue requires them.
- Never commit credentials, OAuth tokens, customer information, or real property photos.

## Workflow and tests

- For behavior changes and bug fixes, write or update a focused test for the intended behavior before changing the implementation when practical. Make the smallest change that satisfies it, then refactor if useful.
- Do not add tests for documentation, formatting, or behavior-preserving refactors unless needed.
- Tests should describe meaningful user or domain behavior, not mirror implementation details. Treat them as executable documentation, and check that their expectations match the requested behavior.
- Preserve the existing test tools and conventions. Avoid duplicate coverage and unnecessary broad or repeated test runs.

## Architecture

- Keep use cases in `com.propertyinspection.application`; name them after the business operation (for example, `GetCustomers`) and have them implement the shared `UseCase` contract.
- Keep domain models, business rules, domain services, and repository ports in `com.propertyinspection.domain`. Domain code must remain independent of application, infrastructure, and framework types.
- Keep framework-specific and external-system code in `com.propertyinspection.infrastructure`, including inbound web adapters and outbound persistence or messaging adapters.
- Inbound adapters translate requests and responses, then call application use cases. Keep business workflows and rules out of controllers.
- Repository ports belong to the domain; persistence adapters in infrastructure implement those ports.
- Dependencies point inward: application may depend on domain; infrastructure may depend on application and domain; domain must not depend on either.
- Keep the Spring Boot entry point in infrastructure and explicitly scan `com.propertyinspection` so all layers are discovered.

## Test conventions

- For Java unit tests, use descriptive names that state the behavior being tested.
- For Java integration tests, use Cucumber with Given/When/Then scenarios written in domain language. Keep step definitions focused.
- For frontend changes, use the existing test tools and write readable tests around user-visible behavior.

## Validation

- Run focused checks relevant to the change first.
- For backend changes, run `mvn -B -f backend/pom.xml verify` when practical. For frontend changes, inspect project scripts and run the relevant existing checks.
- Broaden or repeat checks only when changes, failures, or unresolved risks justify it. Report checks run and their results; state clearly if a relevant check could not be run.
