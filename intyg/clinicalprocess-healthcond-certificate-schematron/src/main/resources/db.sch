<?xml version="1.0" encoding="utf-8"?>
<iso:schema xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:iso="http://purl.oclc.org/dsdl/schematron"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://purl.oclc.org/dsdl/schematron"
  queryBinding='xslt2' schemaVersion='ISO19757-3'>

  <iso:title>Dödsbevis</iso:title>

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
      <iso:assert test="count(gn:svar[@id='5']) = 1">
        Ett intyg måste ha ett 'Explosiv imlpantat'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='6']) = 1">
        Ett intyg måste ha en 'Undersökning'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='7']) = 1">
        Ett intyg måste ha en 'Polisanmälan'
      </iso:assert>

      <iso:let name="svarsIdExpr" value="'^[1234567]$'"/>
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

  <iso:pattern id="q5">
    <iso:rule context="//gn:svar[@id='5']">
      <iso:assert test="count(gn:delsvar[@id='5.1']) = 1">
        'Explosiv implantat måste ha ett 'Finns explosiv implantat'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='5.2']) le 1">
        'Explosiv implantat får högst ha ett 'Har implantatet avlägsnats'
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^5\.[12]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q5.1">
    <iso:rule context="//gn:delsvar[@id='5.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q5.2-5.1">
    <iso:rule context="//gn:delsvar[@id='5.1' and matches(normalize-space(.), '0|false')]">
      <iso:assert test="not(//gn:delsvar[@id='5.2'])">
        Om 'Finns explosiv implantat' är false får inte 'Har implantat avlägsnats' finnas
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='5.2' and ../gn:delsvar[@id='5.1' and matches(normalize-space(.), '1|true')]]">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <!-- Om vi kommer hit så betyder det att 5.2 inte finns fast 5.1 är true -->
    <iso:rule context="//gn:delsvar[@id='5.1' and matches(normalize-space(.), '1|true')]">
      <iso:assert test="count(//gn:delsvar[@id='5.2']) = 1">
        Om 'Finns explosiv implantat' är true måste 'Har implantat avlägsnats' finnas
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q6">
    <iso:rule context="//gn:svar[@id='6']">
      <iso:assert test="count(gn:delsvar[@id='6.1']) = 1">
        'Undersökning' måste ha en 'Om undersökning'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='6.2']) le 1">
        'Undersökning' får ha högst en 'Detaljer undersökning'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='6.3']) le 1">
        'Undersökning' får ha högst ett 'Datum undersökning före döden'
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^6\.[123]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q6.1">
    <iso:rule context="//gn:delsvar[@id='6.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q6.2-6.1">
    <iso:rule context="//gn:delsvar[@id='6.1' and matches(normalize-space(.), '1|true')]">
      <iso:assert test="not(//gn:delsvar[@id='6.2'])">
        Om 'Om undersökning' är true får inte 'Detaljer undersökning' finnas
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='6.2' and ../gn:delsvar[@id='6.1' and matches(normalize-space(.), '0|false')]]">
      <iso:extends rule="cv"/>
      <!-- TODO: codeSystem etc -->
    </iso:rule>
    <!-- Om vi kommer hit så betyder det att 6.2 inte finns fast 6.1 är false -->
    <iso:rule context="//gn:delsvar[@id='6.1' and matches(normalize-space(.), '0|false')]">
      <iso:assert test="count(//gn:delsvar[@id='6.2']) = 1">
        Om 'Om undersökning' är false måste 'Detaljer undersökning' finnas
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <!-- TODO: Ändra till rätt kod när kodystem finns -->
  <iso:pattern id="q6.3-6.2">
    <iso:rule context="//gn:delsvar[@id='6.2' and not(matches(normalize-space(./tp:cv/tp:code), '^Den avlidne undersökt kort före döden$'))]">
      <iso:assert test="not(//gn:delsvar[@id='6.3'])">
        Om 'Detaljer undersökning' inte är 'Den avlidne undersökt kort före döden' får inte 'Datum undersökning före döden' finnas
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='6.3' and ../gn:delsvar[@id='6.2' and matches(normalize-space(.), '^Den avlidne undersökt kort före döden$')]]">
      <iso:extends rule="date"/>
    </iso:rule>
    <!-- Om vi kommer hit så betyder det att 6.3 inte finns fast 6.2 är satt till att den avlidne är undersökt kort före döden -->
    <iso:rule context="//gn:delsvar[@id='6.2' and matches(normalize-space(./tp:cv/tp:code), '^Den avlidne undersökt kort före döden$')]">
      <iso:assert test="count(//gn:delsvar[@id='6.3']) = 1">
        Om 'Detaljer undersökning' är 'Den avlidne undersökt kort före döden' måste 'Datum undersökning före döden' finnas
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q7">
    <iso:rule context="//gn:svar[@id='7']">
      <iso:assert test="count(gn:delsvar[@id='7.1']) = 1">
        'Polisanmälan' måste ha en 'Om polisanmälan'
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^7\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q7.1">
    <iso:rule context="//gn:delsvar[@id='7.1']">
      <iso:extends rule="boolean"/>
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