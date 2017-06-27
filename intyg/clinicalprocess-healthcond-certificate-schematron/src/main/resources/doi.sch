<?xml version="1.0" encoding="utf-8"?>
<iso:schema xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:iso="http://purl.oclc.org/dsdl/schematron"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://purl.oclc.org/dsdl/schematron"
  queryBinding='xslt2' schemaVersion='ISO19757-3'>

  <iso:title>Dödsorsakintyg</iso:title>

  <iso:ns prefix="xs" uri="http://www.w3.org/2001/XMLSchema"/>
  <iso:ns prefix="rg" uri="urn:riv:clinicalprocess:healthcond:certificate:RegisterCertificateResponder:3"/>
  <iso:ns prefix="gn" uri="urn:riv:clinicalprocess:healthcond:certificate:3"/>
  <iso:ns prefix="tp" uri="urn:riv:clinicalprocess:healthcond:certificate:types:3"/>

  <iso:pattern id="intyg">
    <iso:rule context="//rg:intyg">
      <iso:assert test="count(gn:svar[@id='1']) = 1">
        Ett intyg måste ha en 'Identiteten styrkt'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='2']) = 1">
        Ett intyg måste ha ett 'Dödsdatum'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='3']) = 1">
        Ett intyg måste ha en 'Dödsplats'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='4']) = 1">
        Ett intyg måste ha ett 'Barn avlidit'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='8']) = 1">
        Ett intyg måste ha en 'Terminal dödsorsak'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='9']) le 3">
        Ett intyg får ha upp till tre 'Som följd'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='10']) le 8">
        Ett intyg får ha upp till åtta 'Bidragande sjukdom skador'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='11']) = 1">
        Ett intyg måste ha en 'Operation inom fyra veckor'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='12']) = 1">
        Ett intyg måste ha en 'Skada förgiftning'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='13']) = 1">
        Ett intyg måste ha en 'Grunder för dödsorsaksuppgifter'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='14']) le 1">
        Ett intyg får ha upp till ett 'Land'
      </iso:assert>

      <iso:let name="svarsIdExpr" value="'^([123489]|1[01234])$'"/>
      <iso:assert test="count(gn:svar[not(matches(@id, $svarsIdExpr))]) = 0">
        Oväntat svars-id. Svars-id:n måste matcha "<value-of select="$svarsIdExpr"/>".
      </iso:assert>
      <!-- Meddelandet kan innehålla ett valfritt antal tilläggsfrågor -->
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q1">
    <iso:rule context="//gn:svar[@id='1']">
      <iso:assert test="count(gn:delsvar[@id='1.1']) = 1">
        'Identitet styrkt' måste ha en 'Om identiteten styrkt'
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^1\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q1.1">
    <iso:rule context="//gn:delsvar[@id='1.1']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q2">
    <iso:rule context="//gn:svar[@id='2']">
      <iso:assert test="count(gn:delsvar[@id='2.1']) = 1">
        'Dödsdatum' måste ha ett 'Säkert ej säkert'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='2.2']) = 1">
        'Dödsdatum' måste ha en 'Om dödsdatum'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='2.3']) le 1">
        'Dödsdatum' får högst ha ett 'Anträffat död'
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^2\.[123]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q2.1">
    <iso:rule context="//gn:delsvar[@id='2.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q2.2-2.1">
    <iso:rule context="//gn:delsvar[@id='2.2' and ../gn:delsvar[@id='2.1' and matches(normalize-space(.), '1|true')]]">
      <iso:extends rule="date"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='2.2' and ../gn:delsvar[@id='2.1' and matches(normalize-space(.), '0|false')]]">
      <iso:extends rule="partial-date"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q2.3-2.1">
    <iso:rule context="//gn:delsvar[@id='2.1' and matches(normalize-space(.), '1|true')]">
      <iso:assert test="not(//gn:delsvar[@id='2.3'])">
        'Anträffad död' får inte finnas om 'Säkert ej säkert' är true
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='2.3' and ../gn:delsvar[@id='2.1' and matches(normalize-space(.), '0|false')]]">
      <iso:extends rule="date"/>
    </iso:rule>
    <!-- Om vi kommer hit så betyder det att 2.3 inte finns fast 2.1 är false -->
    <iso:rule context="//gn:delsvar[@id='2.1' and matches(normalize-space(.), '0|false')]">
      <iso:assert test="count(//gn:delsvar[@id='2.3']) = 1">
        'Anträffad död' måste finnas om 'Säkert ej säkert' är false
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q3">
    <iso:rule context="//gn:svar[@id='3']">
      <iso:assert test="count(gn:delsvar[@id='3.1']) = 1">
        'Dödsplats' måste ha en 'Kommun där kropp påträffades'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='3.2']) = 1">
        'Dödsplats' måste ha ett 'Boende'
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^3\.[12]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q3.1">
    <iso:rule context="//gn:delsvar[@id='3.1']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q3.2">
    <iso:rule context="//gn:delsvar[@id='3.2']">
      <iso:extends rule="cv"/>
      <!-- TODO: add codeSystem etc -->
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q4">
    <iso:rule context="//gn:svar[@id='4']">
      <iso:assert test="count(gn:delsvar[@id='4.1']) = 1">
        'Barn avlidit' måste ha ett 'Om barn avlidit'
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^4\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q4.1">
    <iso:rule context="//gn:delsvar[@id='4.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q8">
    <iso:rule context="//gn:svar[@id='8']">
      <iso:assert test="count(gn:delsvar[@id='8.1']) = 1">
        'Terminal dödsorsak' måste ha en 'Om terminal dödsorsak'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='8.2']) le 1">
        'Terminal dödsorsak' får ha upp till ett 'Datum terminal dödsorsak'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='8.3']) le 1">
        'Terminal dödsorsak' får ha upp till ett 'Specifikation terminal dödsorsak'
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^8\.[123]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q8.1">
    <iso:rule context="//gn:delsvar[@id='8.1']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q8.2">
    <iso:rule context="//gn:delsvar[@id='8.2']">
      <iso:extends rule="date"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q8.3">
    <iso:rule context="//gn:delsvar[@id='8.3']">
      <iso:extends rule="cv"/>
      <!-- TODO: add codeSystem etc -->
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q9">
    <iso:rule context="//gn:svar[@id='9']">
      <iso:assert test="count(gn:instans) = 1">
        'Som följd' måste ha ett instansnummer.
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='9.1']) le 1">
        'Som följd' måste ha en 'Om som följd'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='9.2']) le 1">
        'Som följd' får ha upp till ett 'Datum som följd'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='9.3']) le 1">
        'Som följd' får ha upp till ett 'Specifikation som följd'
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^9\.[123]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q9.1">
    <iso:rule context="//gn:delsvar[@id='9.1']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q9.2">
    <iso:rule context="//gn:delsvar[@id='9.2']">
      <iso:extends rule="date"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q9.3">
    <iso:rule context="//gn:delsvar[@id='9.3']">
      <iso:extends rule="cv"/>
      <!-- TODO: add codeSystem etc -->
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q9-instans">
    <iso:rule context="//gn:svar[@id='9' and number(gn:instans) ge 2]">
      <iso:let name="instansNr" value="number(gn:instans)"/>
      <iso:assert test="count(//gn:svar[@id='9' and number(gn:instans) = $instansNr - 1]) = 1">
        Instansnummer för 'Som följd' måste vara en sekventiell sifferföljd (1,2,3)
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q10">
    <iso:rule context="//gn:svar[@id='10']">
      <iso:assert test="count(gn:delsvar[@id='10.1']) = 1">
        'Bidragande sjukdom skador' får ha upp till en 'Om bidragande sjukdom skador'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='10.2']) = 1">
        'Bidragande sjukdom skador' får ha upp till ett 'Datum bidragande sjukdom skador'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='10.3']) = 1">
        'Bidragande sjukdom skador' får ha upp till ett 'Specifikation bidragande sjukdom skador'
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^10\.[123]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q10.1">
    <iso:rule context="//gn:delsvar[@id='10.1']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q10.2">
    <iso:rule context="//gn:delsvar[@id='10.2']">
      <iso:extends rule="date"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q10.3">
    <iso:rule context="//gn:delsvar[@id='10.3']">
      <iso:extends rule="cv"/>
      <!-- TODO: add codeSystem etc -->
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q11">
    <iso:rule context="//gn:svar[@id='11']">
      <iso:assert test="count(gn:delsvar[@id='11.1']) = 1">
        'Operation inom fyra veckor' måste ha en 'Om operation inom fyra veckor'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='11.2']) le 1">
        'Operation inom fyra veckor' får ha upp till ett 'Datum operation'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='11.3']) le 1">
        'Operation inom fyra veckor' får ha upp till ett 'Anledning operation'
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^11\.[123]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q11.1">
    <iso:rule context="//gn:delsvar[@id='11.1']">
      <iso:extends rule="cv"/>
      <!-- TODO: add codeSystem etc -->
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q11.2">
    <iso:rule context="//gn:delsvar[@id='11.2']">
      <iso:extends rule="date"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q11.3">
    <iso:rule context="//gn:delsvar[@id='11.3']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q12">
    <iso:rule context="//gn:svar[@id='12']">
      <iso:assert test="count(gn:delsvar[@id='12.1']) = 1">
        'Skada förgiftning' måste ha en 'Om skada förgiftning'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='12.2']) le 1">
        'Skada förgiftning' får ha upp till en 'Orsak skada förgiftning'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='12.3']) le 1">
        'Skada förgiftning' får ha upp till ett 'Datum skada förgiftning'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='12.4']) le 1">
        'Skada förgiftning' får ha upp till en 'Uppkommelse skada förgiftning'
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^12\.[1234]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q12.1">
    <iso:rule context="//gn:delsvar[@id='12.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q12.2-12.1">
    <iso:rule context="//gn:delsvar[@id='12.1' and matches(normalize-space(.), '0|false')]">
      <iso:assert test="not(//gn:delsvar[@id='12.2'])">
          'Orsak skada förgiftning' får inte finnas om 'Om skada förgiftning' är false
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='12.2' and ../gn:delsvar[@id='12.1' and matches(normalize-space(.), '1|true')]]">
      <iso:extends rule="cv"/>
      <!-- TODO: add codeSystem etc -->
    </iso:rule>
    <!-- Om vi kommer hit så betyder det att 12.2 inte finns fast 12.1 är true -->
    <iso:rule context="//gn:delsvar[@id='12.1' and matches(normalize-space(.), '1|true')]">
      <iso:assert test="count(//gn:delsvar[@id='12.2']) = 1">
          'Orsak skada förgiftning' måste finnas om 'Om skada förgiftning' är false
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q13.2-12.1">
    <iso:rule context="//gn:delsvar[@id='12.1' and matches(normalize-space(.), '0|false')]">
      <iso:assert test="not(//gn:delsvar[@id='12.3'])">
          'Datum skada förgiftning' får inte finnas om 'Om skada förgiftning' är false
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='12.3' and ../gn:delsvar[@id='12.1' and matches(normalize-space(.), '1|true')]]">
      <iso:extends rule="date"/>
    </iso:rule>
    <!-- Om vi kommer hit så betyder det att 12.3 inte finns fast 12.1 är true -->
    <iso:rule context="//gn:delsvar[@id='12.1' and matches(normalize-space(.), '1|true')]">
      <iso:assert test="count(//gn:delsvar[@id='12.3']) = 1">
          'Datum skada förgiftning' måste finnas om 'Om skada förgiftning' är false
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q14.2-12.1">
    <iso:rule context="//gn:delsvar[@id='12.1' and matches(normalize-space(.), '0|false')]">
      <iso:assert test="not(//gn:delsvar[@id='12.4'])">
          'Uppkommelse skada förgiftning' får inte finnas om 'Om skada förgiftning' är false
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='12.4' and ../gn:delsvar[@id='12.1' and matches(normalize-space(.), '1|true')]]">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
    <!-- Om vi kommer hit så betyder det att 12.4 inte finns fast 12.1 är true -->
    <iso:rule context="//gn:delsvar[@id='12.1' and matches(normalize-space(.), '1|true')]">
      <iso:assert test="count(//gn:delsvar[@id='12.4']) = 1">
          'Uppkommelse skada förgiftning' måste finnas om 'Om skada förgiftning' är false
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q13">
    <iso:rule context="//gn:svar[@id='13']">
      <iso:assert test="count(gn:delsvar[@id='13.1']) = 1">
        'Grunder för dödsorsaksuppgifter' måste ha ett 'Om grunder för dödsorsaksuppgifter'
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^13\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q13.1">
    <iso:rule context="//gn:delsvar[@id='13.1']">
      <iso:extends rule="cv"/>
      <!-- TODO: add codeSystem etc -->
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q14">
    <iso:rule context="//gn:svar[@id='14']">
      <iso:assert test="count(gn:delsvar[@id='14.1']) = 1">
        'Land' måste ha ett 'Om land'
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^14\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q14.1">
    <iso:rule context="//gn:delsvar[@id='14.1']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="instans-pattern">
    <iso:rule context="//gn:instans">
      <iso:assert test="number(.) ge 1">
        'Instans' måste vara större än 0.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="non-empty-string-pattern">
    <iso:rule id="non-empty-string" abstract="true">
      <iso:assert test="count(*) = 0">Värdet får inte vara inbäddat i något element.</iso:assert>
      <iso:assert test="string-length(normalize-space(text())) > 0">Sträng kan inte vara tom.</iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="boolean-pattern">
    <iso:rule id="boolean" abstract="true">
      <iso:assert test="count(*) = 0">Booleskt värde får inte vara inbäddat i något element.</iso:assert>
      <iso:assert test=". castable as xs:boolean">Kan bara vara 'true/1' eller 'false/0'</iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="cv-pattern">
    <iso:rule id="cv" abstract="true">
      <iso:assert test="count(tp:cv) = 1">Ett värde av typen CV måste ha ett cv-element</iso:assert>
      <iso:assert test="count(tp:cv/tp:codeSystem) = 1">codeSystem är obligatoriskt</iso:assert>
      <iso:assert test="tp:cv/tp:codeSystem/count(*) = 0">'codeSystem' får inte vara inbäddat i något element.</iso:assert>
      <iso:assert test="count(tp:cv/tp:code) = 1">code är obligatoriskt</iso:assert>
      <iso:assert test="tp:cv/tp:code/count(*) = 0">'code' får inte vara inbäddat i något element.</iso:assert>
      <iso:assert test="count(tp:cv/tp:displayName) le 1">högst ett displayName kan anges</iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="date-pattern">
    <iso:rule id="date" abstract="true">
      <iso:assert test="count(*) = 0">Datum får inte vara inbäddat i något element.</iso:assert>
      <iso:assert test=". castable as xs:date">Värdet måste vara ett giltigt datum.</iso:assert>
      <iso:assert test="matches(., '^\d{4}-\d\d-\d\d')">Datumet måste uttryckas som YYYY-MM-DD.</iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="partial-date-pattern">
    <iso:rule id="partial-date" abstract="true">
      <iso:assert test="count(*) = 0">Partiellt datum får inte vara inbäddat i något element.</iso:assert>
      <iso:assert test="matches(., '^\d{4}(-\d\d(-\d\d)?)?$')">Partiellt datum måste uttryckas som YYYY(-MM(-DD)?)?.</iso:assert>
    </iso:rule>
  </iso:pattern>
</iso:schema>