<?xml version="1.0" encoding="utf-8"?>
<iso:schema xmlns="http://purl.oclc.org/dsdl/schematron" xmlns:iso="http://purl.oclc.org/dsdl/schematron"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://purl.oclc.org/dsdl/schematron"
    queryBinding='xslt2' schemaVersion='ISO19757-3'>

  <iso:title>Schematron file for "Arbetsförmedlingens medicinska utlåtande".</iso:title>

  <iso:ns prefix="xs" uri="http://www.w3.org/2001/XMLSchema"/>
  <iso:ns prefix="rg" uri="urn:riv:clinicalprocess:healthcond:certificate:RegisterCertificateResponder:3"/>
  <iso:ns prefix="gn" uri="urn:riv:clinicalprocess:healthcond:certificate:3"/>
  <iso:ns prefix="tp" uri="urn:riv:clinicalprocess:healthcond:certificate:types:3"/>

  <iso:pattern id="intyg">
    <iso:rule context="//rg:intyg">
      <iso:assert test="count(gn:svar[@id='35']) le 1">
        Ett 'MU' får ha högst ett 'Funktionsnedsättning'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='17']) le 1">
        Ett 'MU' får ha högst ett 'Aktivitetsbegränsningar'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='19']) le 1">
        Ett 'MU' får ha högst ett 'Pågående medicinska behandlingar'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='20']) le 1">
        Ett 'MU' får ha högst ett 'Planerade medicinska behandlingar'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='25']) le 1">
        Ett 'MU' får ha högst ett 'Övrigt'
      </iso:assert>
      <iso:let name="svarsIdExpr" value="'^([16]|1[79]|2[056789]|3[234579]|4[04]|9[0-9]{3})$'"/>
      <iso:assert test="count(gn:svar[not(matches(@id, $svarsIdExpr))]) = 0">
        Oväntat svars-id. Svars-id:n måste matcha "<value-of select="$svarsIdExpr"/>".
      </iso:assert>
      <!-- Meddelandet kan innehålla ett valfritt antal tilläggsfrågor -->
    </iso:rule>
  </iso:pattern>


  <iso:pattern id="q29.1">
    <iso:rule context="//gn:delsvar[@id='29.1']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q35">
    <iso:rule context="//gn:svar[@id='35']">
      <iso:assert test="count(gn:delsvar[@id='35.1']) = 1">
        'Funktionsnedsättning' måste ha ett 'Beskrivning'.
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^35\.[1]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q35.1">
    <iso:rule context="//gn:delsvar[@id='35.1']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q17">
    <iso:rule context="//gn:svar[@id='17']">
      <iso:assert test="count(gn:delsvar[@id='17.1']) = 1">
        'Aktivitetsbegränsningar' måste ha ett 'Beskrivning'.
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^17\.[1]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q17.1">
    <iso:rule context="//gn:delsvar[@id='17.1']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q19">
    <iso:rule context="//gn:svar[@id='19']">
      <iso:assert test="count(gn:delsvar[@id='19.1']) = 1">
        'Pågående medicinska behandlingar' måste ha ett 'Typ av pågående behandlingar och ansvarig vårdenhet'.
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^19\.[1]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q19.1">
    <iso:rule context="//gn:delsvar[@id='19.1']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q20">
    <iso:rule context="//gn:svar[@id='20']">
      <iso:assert test="count(gn:delsvar[@id='20.1']) = 1">
        'Planerade medicinska behandlingar' måste ha ett 'Typ av planerade behandlingar och ansvarig vårdenhet'.
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^20\.[1]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q20.1">
    <iso:rule context="//gn:delsvar[@id='20.1']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q25">
    <iso:rule context="//gn:svar[@id='25']">
      <iso:assert test="count(gn:delsvar[@id='25.1']) = 1">
        'Övrigt' måste ha ett 'Typ av övriga upplysningar'.
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^25\.[1]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q25.1">
    <iso:rule context="//gn:delsvar[@id='25.1']">
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

</iso:schema>
