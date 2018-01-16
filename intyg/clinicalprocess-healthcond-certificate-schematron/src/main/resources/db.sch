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

      <iso:let name="svarsIdExpr" value="'^([1234567])$'"/>
      <iso:assert test="count(gn:svar[not(matches(@id, $svarsIdExpr))]) = 0">
        Oväntat svars-id. Svars-id:n måste matcha "<value-of select="$svarsIdExpr"/>".
      </iso:assert>
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

  <iso:pattern id="q2.3">
    <iso:rule context="//gn:delsvar[@id='2.3']">
      <iso:extends rule="date"/>
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
      <iso:assert test="tp:cv/tp:codeSystem = 'KV_DODSPLATS_BOENDE'">'codeSystem' måste vara 'KV_DODSPLATS_BOENDE'.</iso:assert>
      <iso:assert test="matches(normalize-space(tp:cv/tp:code), '^(SJUKHUS|ORDINART_BOENDE|SARSKILT_BOENDE|ANNAN)$')">
        'KV_DODSPLATS_BOENDE' kan ha ett av värdena SJUKHUS, ORDINART_BOENDE, SARSKILT_BOENDE, ANNAN.
      </iso:assert>
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

  <iso:pattern id="q4.1-birth">
    <iso:let name="personId" value="//gn:person-id/tp:extension" />
    <!-- Handle samordningsnummer -->
    <iso:let name="birthDay" value="if (substring($personId,7,2) lt '60') then substring($personId,7,2) else xs:string(xs:integer(substring($personId,7,2)) - 60)" />
    <iso:let name="birthDate" value="xs:date(string-join((substring($personId,1,4),substring($personId,5,2),$birthDay), '-'))"/>
    <iso:rule context="//gn:delsvar[@id='2.1' and matches(normalize-space(.), '1|true') and string(../gn:delsvar[@id='2.2']) castable as xs:date]">
      <iso:assert test="(matches(normalize-space(//gn:delsvar[@id='4.1']), '0|false') or (xs:date(//gn:delsvar[@id='2.2']) le $birthDate + xs:dayTimeDuration('P28D')))">
        Om 'Säkert Ej säkert' besvarats med 'Säkert' OCH om 'Om dödsdatum' är större än 28 dagar efter födelsedatumet ska 'Barn avlidit' endast kunna besvaras med 'Nej'.
      </iso:assert>
      <iso:assert test="(matches(normalize-space(//gn:delsvar[@id='4.1']), '1|true') or (xs:date(//gn:delsvar[@id='2.2']) gt $birthDate + xs:dayTimeDuration('P28D')))">
        Om 'Säkert Ej säkert' besvarats med 'Säkert' OCH om 'Om dödsdatum' är mindre eller lika med 28 dagar efter födelsedatumet ska 'Barn avlidit' endast kunna besvaras med 'Ja'.
      </iso:assert>
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

  <iso:pattern id="q5.2">
    <iso:rule context="//gn:delsvar[@id='5.2']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q5.2-5.1">
    <iso:rule context="//gn:delsvar[@id='5.1' and matches(normalize-space(.), '0|false')]">
      <iso:assert test="not(//gn:delsvar[@id='5.2'])">
        Om 'Finns explosiv implantat' är false får inte 'Har implantat avlägsnats' finnas
      </iso:assert>
    </iso:rule>
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

  <iso:pattern id="q6.2">
    <iso:rule context="//gn:delsvar[@id='6.2' and ../gn:delsvar[@id='6.1' and matches(normalize-space(.), '0|false')]]">
      <iso:extends rule="cv"/>
      <iso:assert test="tp:cv/tp:codeSystem = 'KV_DETALJER_UNDERSOKNING'">'codeSystem' måste vara 'KV_DETALJER_UNDERSOKNING'.</iso:assert>
      <iso:assert test="matches(normalize-space(tp:cv/tp:code), '^(UNDERSOKNING_GJORT|UNDERSOKNING_SKA_GORAS)$')">
        'KV_DETALJER_UNDERSOKNING' kan ha ett av värdena UNDERSOKNING_GJORT, UNDERSOKNING_SKA_GORAS.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q6.3">
    <iso:rule context="//gn:delsvar[@id='6.3' and ../gn:delsvar[@id='6.2' and matches(normalize-space(./tp:cv/tp:code), '^UNDERSOKNING_GJORT$')]]">
      <iso:extends rule="date"/>
      <iso:assert test="not(//gn:delsvar[@id='2.2'] castable as xs:date) or xs:date(.) le xs:date(//gn:delsvar[@id='2.2'])">
        'Datum undersökning före döden' får inte vara efter 'Om dödsdatum'
      </iso:assert>
      <iso:assert test="not(//gn:delsvar[@id='2.3'] castable as xs:date) or xs:date(.) le xs:date(//gn:delsvar[@id='2.3'])">
        'Datum undersökning före döden' får inte vara senare än datumet för 'Anträffad död'
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q6.2-6.1">
    <iso:rule context="//gn:delsvar[@id='6.1' and matches(normalize-space(.), '1|true')]">
      <iso:assert test="not(//gn:delsvar[@id='6.2'])">
        Om 'Om undersökning' är true får inte 'Detaljer undersökning' finnas
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='6.1' and matches(normalize-space(.), '0|false')]">
      <iso:assert test="count(//gn:delsvar[@id='6.2']) = 1">
        Om 'Om undersökning' är false måste 'Detaljer undersökning' finnas
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q6.3-6.2">
    <iso:rule context="//gn:delsvar[@id='6.2' and not(matches(normalize-space(./tp:cv/tp:code), '^UNDERSOKNING_GJORT$'))]">
      <iso:assert test="not(//gn:delsvar[@id='6.3'])">
        Om 'Detaljer undersökning' inte är 'UNDERSOKNING_GJORT' får inte 'Datum undersökning före döden' finnas
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='6.2' and matches(normalize-space(./tp:cv/tp:code), '^UNDERSOKNING_GJORT$')]">
      <iso:assert test="count(//gn:delsvar[@id='6.3']) = 1">
        Om 'Detaljer undersökning' är 'UNDERSOKNING_GJORT' måste 'Datum undersökning före döden' finnas
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
    <iso:rule context="//gn:delsvar[@id='6.2' and matches(normalize-space(./tp:cv/tp:code), '^UNDERSOKNING_SKA_GORAS')]">
      <iso:assert test="//gn:delsvar[@id='7.1' and matches(normalize-space(.), '1|true')]">
        Om 'Detaljer undersökning' är 'UNDERSOKNING_SKA_GORAS' måste 'Om polisanmälan' vara true.
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
      <iso:assert test="matches(., '^\d{4}-\d{2}-\d{2}$')">Partiellt datum måste uttryckas som YYYY-MM-DD (enbart 0:or är acceptabelt.</iso:assert>
    </iso:rule>
  </iso:pattern>
</iso:schema>
