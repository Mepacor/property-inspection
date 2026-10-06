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

- Follow the existing project structure. Keep clear application, domain, and infrastructure boundaries, using ports and adapters where they fit the current design.
- Application use cases coordinate workflows; keep business rules in the domain. Keep the domain independent of infrastructure technologies.
- Controllers and other infrastructure adapters should translate external inputs and outputs, then delegate. Keep business workflows and rules out of controllers.
- Follow existing conventions for use case and repository interfaces; do not impose a new folder or interface structure.

## Test conventions

- For Java unit tests, use descriptive names that state the behavior being tested.
- For Java integration tests, use Cucumber with Given/When/Then scenarios written in domain language. Keep step definitions focused.
- For frontend changes, use the existing test tools and write readable tests around user-visible behavior.

## Validation

- Run focused checks relevant to the change first.
- For backend changes, run `mvn -B -f backend/pom.xml verify` when practical. For frontend changes, inspect project scripts and run the relevant existing checks.
- Broaden or repeat checks only when changes, failures, or unresolved risks justify it. Report checks run and their results; state clearly if a relevant check could not be run.
