# Agent instructions

- Keep changes small and focused on the assigned issue.
- Follow the existing Spring Boot and React conventions; prefer clear names and straightforward code.
- Add or update tests for behavior changes. For new behavior, write the test first.
- Run `mvn -B -f backend/pom.xml verify` and the relevant frontend checks; report results in the pull request.
- Never commit credentials, OAuth tokens, customer information, or real property photos.
- Do not add external integrations or product features unless the issue asks for them.
