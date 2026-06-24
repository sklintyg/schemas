# intyg-schemas Migration Progress (K1J-1993)

## Baseline (pre-migration)

| Component | Version |
|-----------|---------|
| Java | 21 |
| Gradle | 8.14.4 |
| Spring Boot BOM | 3.5.10 |
| wsdl2java | 3.0.0 |
| Jackson | 2.x (`com.fasterxml.jackson`) |

**Modules (11):** `schemas-contract`, `schemas-support`, `intyg-clinicalprocess-healthcond-certificate-schemas`, `intyg-clinicalprocess-healthcond-certificate-schematron`, `intyg-clinicalprocess-healthcond-rehabilitation-schemas`, `intyg-clinicalprocess-healthcond-srs-schemas`, `intyg-transportstyrelsen-schemas`, `clinicalprocess-healthcond-certificate-schemas`, `insuranceprocess-healthreporting-schemas`, `informationsecurity-auditing-log-schemas`, `informationsecurity-authorization-blocking-schemas`, `informationsecurity-authorization-consent-schemas`

---

## Completed phases

| Phase | Date | Verification |
|-------|------|--------------|
| 0 — Baseline and documentation | 2026-06-24 | `./gradlew clean build spotlessCheck` — BUILD SUCCESSFUL |
| 1 — Gradle 9.6.0 | 2026-06-24 | `.\gradlew --version` → 9.6.0; `./gradlew clean build spotlessCheck` — BUILD SUCCESSFUL |
| 2 — Java 25 | 2026-06-24 | `./gradlew clean build spotlessCheck` — BUILD SUCCESSFUL |
| 3 — wsdl2java 4.1.0 | 2026-06-24 | `./gradlew clean build spotlessCheck` — BUILD SUCCESSFUL |
| 4 — Spring Boot 4.1.0 + Jackson 3 | | | |
| 5 — Final dependencies | | | |

---

## Open issues / blockers

_None yet._

---

## Deferred items

| Item | Reason |
|------|--------|
| `lib-builder-image` / `builder.image.tag` | Handled separately in CI |
| Jenkins.properties outside `settings.gradle` | Not part of root Gradle build |
| README still references Maven | Out of scope for lifecycle migration |
| Spring Boot starters / autoconfig | N/A — library project, BOM-only usage |

---

## Dependency decisions

| Decision | Rationale |
|----------|-----------|
| intyg-BOM not upgraded | Not used in this project |
| Jackson 3 (not Jackson 2 compat module) | Per Jira acceptance criteria |
