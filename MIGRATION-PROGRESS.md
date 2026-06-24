# intyg-schemas Migration Progress (K1J-1993)

## Final state (post-migration)

| Component | Version |
|-----------|---------|
| Java | 25 |
| Gradle | 9.6.0 |
| Spring Boot BOM | 4.1.0 |
| Jackson | 3.1.4 (`tools.jackson`) |
| wsdl2java | 4.1.0 |
| CXF runtime | 4.1.4 |
| CXF XJC plugins | 4.1.2 (latest available for xjc-utils/xjcplugins) |

**Gradle plugins:** SonarQube 7.3.1.8318, OWASP dependency-check 12.2.2, CycloneDX 3.2.4, Spotless 8.7.0

---

## Completed phases

| Phase | Date | Verification |
|-------|------|--------------|
| 0 — Baseline and documentation | 2026-06-24 | `./gradlew clean build spotlessCheck` — BUILD SUCCESSFUL |
| 1 — Gradle 9.6.0 | 2026-06-24 | `.\gradlew --version` → 9.6.0; `./gradlew clean build spotlessCheck` — BUILD SUCCESSFUL |
| 2 — Java 25 | 2026-06-24 | `./gradlew clean build spotlessCheck` — BUILD SUCCESSFUL |
| 3 — wsdl2java 4.1.0 | 2026-06-24 | `./gradlew clean build spotlessCheck` — BUILD SUCCESSFUL |
| 4 — Spring Boot 4.1.0 + Jackson 3 | 2026-06-24 | `./gradlew clean build spotlessCheck` + `PersonnummerTest` — BUILD SUCCESSFUL |
| 5 — Final dependencies | 2026-06-24 | `./gradlew clean build spotlessCheck install` + `PersonnummerTest` — BUILD SUCCESSFUL |

**Migration complete.**

---

## Open issues / blockers

_None._

---

## Deferred items

| Item | Reason |
|------|--------|
| `lib-builder-image` / `builder.image.tag` | Handled separately in CI |
| Jenkins.properties outside `settings.gradle` | Not part of root Gradle build |
| README still references Maven | Out of scope for lifecycle migration |
| Spring Boot starters / autoconfig | N/A — library project, BOM-only usage |
| Gradle 10 deprecation warnings | Non-blocking; address in future lifecycle |

---

## Dependency decisions

| Decision | Rationale |
|----------|-----------|
| intyg-BOM not upgraded | Not used in this project |
| Jackson 3 (not Jackson 2 compat module) | Per Jira acceptance criteria |
| `JsonDeserializer` → `ValueDeserializer` | Jackson 3 rename; `deserialize()` no longer throws `IOException` |
| CXF runtime 4.1.4 / XJC plugins 4.1.2 | XJC artifacts (`cxf-xjc-runtime`, `cxf-xjc-ts`) not published at 4.1.4 |
| Guava, JAXB, schematron versions unchanged | Already compatible with Java 25 and SB 4.1; no conflicts observed |
