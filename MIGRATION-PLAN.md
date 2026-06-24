# intyg-schemas Lifecycle Migration Plan (K1J-1993)

## Project context

This repository is a **Gradle multi-module schema library**, not a Spring Boot application. It generates JAXB/WS classes from WSDL/XSD via `com.yupzip.wsdl2java` and publishes JARs to Nexus.

| Area | Current state | Target |
|------|---------------|--------|
| Java | 21 (`build.gradle` toolchain) | 25 |
| Gradle | 8.14.4 (`gradle/wrapper/gradle-wrapper.properties`) | 9.6.0 |
| Spring Boot BOM | 3.5.10 (`springbootVersion` in `build.gradle`) | 4.1.0 |
| Jackson | 2.x (`com.fasterxml.jackson` in `contract/build.gradle`) | 3.x (`tools.jackson`) |
| wsdl2java plugin | 3.0.0 | 4.1.0 (Gradle 9 compatible) |

**11 active Gradle modules** (`settings.gradle`): `schemas-contract`, `schemas-support`, 8 `*-schemas` modules, and `intyg-clinicalprocess-healthcond-certificate-schematron`.

**Explicitly out of scope for this repo:**
- intyg-BOM upgrade (not used here; already on Java 25 / Gradle 9.6.0)
- `lib-builder-image` / `builder.image.tag` updates (handled separately in CI)
- Spring Boot starters / autoconfig migration (no Spring application context)
- Jenkins.properties in directories **not** listed in `settings.gradle`

**Primary references:**
- [Spring Boot 4.0 Migration Guide](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-4.0-Migration-Guide)
- [Jackson 3 migration guide](https://github.com/FasterXML/jackson/blob/main/jackson3/MIGRATING_TO_JACKSON_3.md)
- [wsdl2java 4.x README](https://github.com/yupzip/wsdl2java)

---

## Verification gate (every phase)

Run from repo root after each phase. **Do not start the next phase until all pass:**

```bash
./gradlew clean build spotlessCheck
```

Optional deeper checks when relevant:

```bash
./gradlew test jacocoTestReport
./gradlew :schemas-contract:test --tests PersonnummerTest
./gradlew :intyg-clinicalprocess-healthcond-certificate-schemas:wsdl2java
```

---

## Phase 0 — Baseline and documentation

**Goal:** Establish a green baseline and add tracking files before any version bumps.

**Commit tag:** `K1J-1993: Add lifecycle migration plan and baseline documentation`

- [ ] Add `MIGRATION-PLAN.md` and `MIGRATION-PROGRESS.md`
- [ ] Record current versions and module inventory
- [ ] Run full verification on current baseline (Java 21)

---

## Phase 1 — Gradle 9.6.0

**Goal:** Upgrade the wrapper only; keep Java 21 and Spring Boot 3.5.10 stable.

**Commit tag:** `K1J-1993: Upgrade Gradle wrapper to 9.6.0`

- [x] Update `gradle/wrapper/gradle-wrapper.properties` to Gradle 9.6.0
- [x] Fix plugin compatibility issues if build fails
- [x] Run verification gate

---

## Phase 2 — Java 25

**Goal:** Move compilation/toolchain to Java 25 on Gradle 9.

**Commit tag:** `K1J-1993: Upgrade Java toolchain to 25`

- [x] Set `JavaLanguageVersion.of(25)` in `build.gradle`
- [x] Run verification gate

---

## Phase 3 — wsdl2java 4.1.0

**Goal:** Upgrade WSDL/XSD code-generation plugin for Gradle 9.

**Commit tag:** `K1J-1993: Upgrade wsdl2java plugin to 4.1.0`

- [x] Upgrade plugin to 4.1.0
- [x] Remove `includeJava8XmlDependencies`; use string paths for `wsdlDir` / `generatedWsdlDir`
- [x] Pin `cxfVersion` / `cxfPluginVersion` via extension (restored in plugin 4.1.0)
- [x] Run verification gate

---

## Phase 4 — Spring Boot 4.1.0 BOM + Jackson 3

**Goal:** Bump BOM and migrate contract module Jackson usage.

**Commit tag:** `K1J-1993: Upgrade Spring Boot BOM to 4.1.0 and migrate to Jackson 3`

- [x] Set `springbootVersion = "4.1.0"`
- [x] Update `contract/build.gradle` to `tools.jackson.core:jackson-databind`
- [x] Migrate `Personnummer.java`, `PersonnummerDeserializer.java`, `PersonnummerTest.java`
- [x] Run verification gate and `PersonnummerTest`

---

## Phase 5 — Remaining dependencies and final verification

**Goal:** Align explicit versions with SB 4.1 / Gradle 9 ecosystem.

**Commit tag:** `K1J-1993: Align remaining dependencies and complete lifecycle migration`

- [x] Review and bump `ext` dependency versions
- [x] Review Gradle plugin versions
- [x] Run final verification checklist
- [x] Close out `MIGRATION-PROGRESS.md`

---

## Spring Boot starters / autoconfig (N/A)

This repo only imports `spring-boot-dependencies` as a BOM for transitive version alignment. No Spring application context exists.

---

## Implementation workflow

After **each** phase:

1. Run verification gate
2. Update `MIGRATION-PROGRESS.md`
3. **Stop** — commit with the phase tag above before continuing
4. Only proceed when build + tests are green
