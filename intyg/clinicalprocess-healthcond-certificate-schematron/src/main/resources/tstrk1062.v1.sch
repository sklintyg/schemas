<?xml version="1.0" encoding="utf-8"?>
<iso:schema
    xmlns="http://purl.oclc.org/dsdl/schematron"
    xmlns:iso="http://purl.oclc.org/dsdl/schematron"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://purl.oclc.org/dsdl/schematron"
    queryBinding='xslt2'
    schemaVersion='ISO19757-3'>

  <iso:title>Schematron file for "Läkarintyg avseende ADHD, autismspektrumtillstånd och likartade tillstånd samt psykisk
    utvecklingsstörning" - Version 1.
  </iso:title>

  <iso:ns prefix="xs" uri="http://www.w3.org/2001/XMLSchema"/>
  <iso:ns prefix="rg" uri="urn:riv:clinicalprocess:healthcond:certificate:RegisterCertificateResponder:3"/>
  <iso:ns prefix="gn" uri="urn:riv:clinicalprocess:healthcond:certificate:3"/>
  <iso:ns prefix="tp" uri="urn:riv:clinicalprocess:healthcond:certificate:types:3"/>


  <iso:pattern id="intyg">
    <iso:rule context="//rg:intyg">
      <iso:assert test="count(gn:svar[@id='1']) ge 1 and count(gn:svar[@id='1']) le 16">
        Ett 'MU' måste ha mellan 1 och 16 'Intyget avser behörighet'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='2']) = 1">
        Ett 'MU' måste ha en 'Identitet styrkt genom'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='51']) > 0 or count(gn:svar[@id='52']) = 1">
        Ett 'MU' måste ha antingen 'Diagnos kodad' eller 'Diagnos fritext'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='51']) le 4">
        Ett 'MU' får ha högst fyra 'Diagnos kodad'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='53']) = 1">
        Ett 'MU' måste ha en 'Läkemedelsbehandling för angivna diagnoser har förekommit'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='54']) le 1">
        Ett 'MU' får ha högst ett 'Läkemedelsbehandling för angivna diagnoser pågår'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='55']) le 1">
        Ett 'MU' får ha högst ett 'Aktuell läkemedelsbehandling '
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='56']) le 1">
        Ett 'MU' får ha högst ett 'Läkemedelsbehandling i mer än tre år'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='57']) le 1">
        Ett 'MU' får ha högst ett 'Behandlingseffekt har varit god under senaste två åren'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='58']) le 1">
        Ett 'MU' får ha högst ett Behandlingsföljsamheten är god'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='59']) le 1">
        Ett 'MU' får ha högst ett 'Avslutad läkemedelsbehandling'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='60']) = 1">
        Ett 'MU' måste ha en 'Bedömning av symptom, funktionshinder och prognos för fortsatt stabilitet'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='61']) = 1">
        Ett 'MU' måste ha en 'Prognos för fortsatt stabilt tillstånd är god'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='32']) le 1">
        Ett 'MU' får ha högst ett 'Övriga relevanta kommentarer'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='33']) ge 1 and count(gn:svar[@id='33']) le 16">
        Ett 'MU' måste ha mellan 1 och 16 'Uppfyller krav för behörighet'
      </iso:assert>
      <iso:let name="svarsIdExpr" value="'^([1]|[2]|5[1-9]|6[01]|3[23])$'"/>
      <iso:assert test="count(gn:svar[not(matches(@id, $svarsIdExpr))]) = 0">
        Oväntat svars-id. Svars-id:n måste matcha "<value-of select="$svarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>


  <iso:pattern id="q1">
    <iso:rule context="//gn:svar[@id='1']">
      <iso:let name="delsvarsIdExpr" value="'^1\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id=1.1]) = 1">
        'Intyget avser behörighet' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='1.1']">
      <iso:extends rule="cv"/>
      <iso:assert test="tp:cv/tp:codeSystem = '24c41b8d-258a-46bf-a08a-b90738b28770'">'codeSystem' måste vara
        '24c41b8d-258a-46bf-a08a-b90738b28770'.
      </iso:assert>
      <iso:assert test="matches(normalize-space(tp:cv/tp:code), '^IAV([1-9]$|1[1-7]$)')">
        'Intyget avser behörighet' kan ha ett av värdena IAV1 - IAV9 eller IAV11 - IAV17.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q2">
    <iso:rule context="//gn:svar[@id='2']">
      <iso:let name="delsvarsIdExpr" value="'^2\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='2.1']) = 1">
        'Identitet styrkt genom' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvarsvar[@id='2.1']">
      <iso:extends rule="cv"/>
      <iso:assert test="tp:cv/tp:codeSystem = 'e7cc8f30-a353-4c42-b17a-a189b6876647'">
        'codeSystem' måste vara 'e7cc8f30-a353-4c42-b17a-a189b6876647'.
      </iso:assert>
      <iso:assert test="matches(normalize-space(tp:cv/tp:code), '^IDK[1-6]$')">
        'Identitet styrkt genom' kan ha ett av värdena IDK1 - IDK6.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q51">
    <iso:rule context="//gn:svar[@id='51']">
      <iso:assert test="count(gn:delsvar[@id='51.1']) = 1">
        'Diagnos kodad' måste ha en diagnoskod.
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='51.2']) &lt;= 1">
        'Diagnos kodad' får inte ha mer än en diagnostext.
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='51.3']) = 1">
        'Diagnos kodad' måste ha ett årtal.
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^51\.[1-3]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
      <iso:assert test="count(//gn:svar[@id='52']) = 0">
        'Diagnos kodad' får inte finnas samtidigt som 'Diagnos fritext'
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='51.1']"> 
      <iso:extends rule="cv"/>
      <iso:assert test="matches(normalize-space(tp:cv/tp:codeSystem), '^(1.2.752.116.1.1.1.1.3)$')">
        Diagnoskodsystem måste vara OID för ICD-10-SE.
      </iso:assert>
      <iso:assert test="matches(normalize-space(tp:cv/tp:code),'^([A-EG-Ya-eg-y][0-9]{2}[A-Za-z0-9-]*|[Zz][0-689][0-9][A-Za-z0-9-]*|[Zz]7[0-24-9][A-Za-z0-9-]*|[Zz]73[A-Za-z0-9-]+|[Ff][0-9]{2}[A-Za-z0-9-]+)$')">
        Diagnoskod måste anges som bokstav följt av två siffror följt av noll eller flera bokstäver, siffror eller bindestreck, d.v.s. minst tre positioner
        måste anges. Om diagnoskoden börjar med F eller Z73 måste bokstav och två siffor följas av minst en bokstav, siffra eller bindestreck, d.v.s. minst fyra
        positioner måste anges.
      </iso:assert>
      <iso:assert test="string-length(normalize-space(tp:cv/tp:code)) le 5">
        Diagnoskod får inte vara längre än 5 tecken.
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='51.2']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='51.3']">
      <iso:extends rule="partial-date"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q52">
    <iso:rule context="//gn:svar[@id='52']">
      <iso:assert test="count(gn:delsvar[@id='52.1']) = 1">
        'Diagnos fritext' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='52.2']) = 1">
        'Årtal för diagnoser' måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^52\.[12]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
      <iso:assert test="count(//gn:svar[@id='51']) = 0">
        'Diagnos fritext' får inte finnas samtidigt som 'Diagnos kodad'
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='52.1']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='52.2']">
      <iso:extends rule="partial-date"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q53">
    <iso:rule context="//gn:svar[@id='53']">
      <iso:assert test="count(gn:delsvar[@id='53.1']) = 1">
        'Läkemedelsbehandling för angivna diagnoser har förekommit' måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^53\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='53.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        'Läkemedelsbehandling för angivna diagnoser har förekommit' måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q54">
    <iso:rule context="//gn:svar[@id='54']">
      <iso:assert test="count(gn:delsvar[@id='54.1']) = 1">
        'Läkemedelsbehandling för angivna diagnoser pågår' måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^54\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='54.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        'Läkemedelsbehandling för angivna diagnoser pågår' måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q55">
    <iso:rule context="//gn:svar[@id='55']">
      <iso:assert test="count(gn:delsvar[@id='55.1']) = 1">
        'Läkemedelsbehandling för angivna diagnoser pågår' måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^55\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='55.1']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q56">
    <iso:rule context="//gn:svar[@id='56']">
      <iso:assert test="count(gn:delsvar[@id='56.1']) = 1">
        'Läkemedelsbehandling i mer än tre år' måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^56\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='56.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        'Läkemedelsbehandling i mer än tre år' måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q57">
    <iso:rule context="//gn:svar[@id='57']">
      <iso:assert test="count(gn:delsvar[@id='57.1']) = 1">
        'Behandlingseffekt har varit god under senaste två åren' måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^57\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='57.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        'Behandlingseffekt har varit god under senaste två åren' måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q58">
    <iso:rule context="//gn:svar[@id='58']">
      <iso:assert test="count(gn:delsvar[@id='58.1']) = 1">
        'Behandlingsföljsamheten är god' måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^58\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='57.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        'Behandlingsföljsamheten är god' måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q59">
    <iso:rule context="//gn:svar[@id='59']">
      <iso:assert test="count(gn:delsvar[@id='59.1']) = 1">
        'Avslutad läkemedelsbehandling ' måste ha delsvar 'Tidpunkt då läkemedelsbehandling avslutades'
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='59.2']) = 1">
        'Avslutad läkemedelsbehandling ' måste ha delsvar 'Orsak till att läkemedelsbehandling avslutades'
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^59\.[12]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='59.1']">
      <iso:extends rule="date"/>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='59.2']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q60">
    <iso:rule context="//gn:svar[@id='60']">
      <iso:assert test="count(gn:delsvar[@id='60.1']) = 1">
        'Bedömning av symptom, funktionshinder och prognos för fortsatt stabilitet' måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^60\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='60.1']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q61">
    <iso:rule context="//gn:svar[@id='61']">
      <iso:let name="delsvarsIdExpr" value="'^61\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='61.1']) = 1">
        'Prognos för fortsatt stabilt tillstånd är god' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvarsvar[@id='61.1']">
      <iso:extends rule="cv"/>
      <iso:assert test="matches(normalize-space(tp:cv/tp:code), '^[true|false|NI]$')">
        'Prognos för fortsatt stabilt tillstånd är god' kan ha ett följande värden; true, false eller NI
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q32">
    <iso:rule context="//gn:svar[@id='32']">
      <iso:assert test="count(gn:delsvar[@id='32.1']) = 1">
        'Övriga relevanta kommentarer' måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^32\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='32.1']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q33">
    <iso:rule context="//gn:svar[@id='33']">
      <iso:let name="delsvarsIdExpr" value="'^33\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='33.1']) = 1">
        'Uppfyller krav för behörighet' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='33.1']">
      <iso:extends rule="cv"/>
      <iso:assert test="tp:cv/tp:codeSystem = 'e889fa20-1dee-4f79-8b37-03853e75a9f8'">'codeSystem' måste vara
        'e889fa20-1dee-4f79-8b37-03853e75a9f8'.
      </iso:assert>
      <iso:assert test="matches(normalize-space(tp:cv/tp:code), '^VAR([1-9]$|1[1-8]$)')">
        'Uppfyller krav för behörighet' kan ha ett av värdena IAV1 - IAV9 eller IAV11 - IAV18.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R1">
    <iso:rule context="//gn:delsvar[@id='53.1' and matches(normalize-space(.), '^true$|^1$')]">
      <iso:assert test="count(//gn:delsvar[@id='54.1']) = 1">
        Om 'Läkemedelsbehandling för angivna diagnoser har förekommit' är besvarat måste även
        'Läkemedelsbehandling för angivna diagnoser pågår' besvaras.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R2-R3-R4-R5">
    <iso:rule context="//gn:delsvar[@id='54.1' and matches(normalize-space(.), '^true$|^1$')]">
      <iso:assert test="count(//gn:delsvar[@id='55.1']) = 1">
        Om 'Läkemedelsbehandling för angivna diagnoser pågår' är besvarat med 'true' måste även
        'Aktuell läkemedelsbehandling' besvaras.
      </iso:assert>
      <iso:assert test="count(//gn:delsvar[@id='56.1']) = 1">
        Om 'Läkemedelsbehandling för angivna diagnoser pågår' är besvarat med 'true' måste även
        'Läkemedelsbehandling i mer än tre år' besvaras.
      </iso:assert>
      <iso:assert test="count(//gn:delsvar[@id='57.1']) = 1">
        Om 'Läkemedelsbehandling för angivna diagnoser pågår' är besvarat med 'true' måste även
        'Behandlingseffekten har varit god under senaste två åren' besvaras.
      </iso:assert>
      <iso:assert test="count(//gn:delsvar[@id='58.1']) = 1">
        Om 'Läkemedelsbehandling för angivna diagnoser pågår' är besvarat med 'true' måste även
        'Behandlingsföljsamheten är god' besvaras.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R6-R7">
    <iso:rule context="//gn:delsvar[@id='54.1' and matches(normalize-space(.), '^false$|^0$')]">
      <iso:assert test="count(//gn:svar[@id='59']) = 1">
        Om 'Läkemedelsbehandling för angivna diagnoser pågår' är besvarat med 'false' måste även
        'Tidpunkt då läkemedelsbehandling avslutades' och 'Orsak till att läkemedelsbehandling avslutades' besvaras.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R8-R9">
    <iso:rule context="//gn:delsvar[@id='33.1' and matches(normalize-space(tp:cv/tp:code), '^VAR11$')]">
      <iso:assert test="count(//gn:delsvar[@id='33.1']) = 1">
        Om 'Uppfyller krav för behörighet' har värdet VAR11 får frågan endast ha ett svar.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="cv-pattern">
    <iso:rule id="cv" abstract="true">
      <iso:assert test="count(tp:cv) = 1">Ett värde av typen CV måste ha ett cv-element</iso:assert>
      <iso:assert test="count(tp:cv/tp:codeSystem) = 1">codeSystem är obligatoriskt</iso:assert>
      <iso:assert test="tp:cv/tp:codeSystem/count(*) = 0">'codeSystem' får inte vara inbäddat i något element.
      </iso:assert>
      <iso:assert test="count(tp:cv/tp:code) = 1">code är obligatoriskt</iso:assert>
      <iso:assert test="tp:cv/tp:code/count(*) = 0">'code' får inte vara inbäddat i något element.</iso:assert>
      <iso:assert test="count(tp:cv/tp:displayName) le 1">högst ett displayName kan anges</iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="date-pattern">
    <iso:rule id="date" abstract="true">
      <iso:assert test="count(*) = 0">Datum får inte vara inbäddat i något element.</iso:assert>
      <iso:assert test=". castable as xs:date">Värdet måste vara ett giltigt datum.</iso:assert>
      <iso:assert test="matches(., '^\d{4}-\d{2}-\d{2}')">Datumet måste uttryckas som YYYY-MM-DD.</iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="partial-date-pattern">
    <iso:rule id="partial-date" abstract="true">
      <iso:assert test="matches(tp:partialDate/tp:value, '^\d{4}$')">Datumet måste uttryckas som YYYY.</iso:assert>
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

  <iso:pattern id="decimal-pattern">
    <iso:rule id="decimal" abstract="true">
      <iso:assert test="count(*) = 0">Decimal-värde får inte vara inbäddat i något element.</iso:assert>
      <iso:assert test=". castable as xs:decimal">Decimalvärde</iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="decimal-value-less-equal-2-pattern">
    <iso:rule id="decimal-le-2" abstract="true">
      <iso:assert test="count(*) = 0">Decimal-värde får inte vara inbäddat i något element.</iso:assert>
      <iso:assert test=". castable as xs:decimal">Decimalvärde</iso:assert>
      <iso:assert test="abs(.) &lt;= 2.0">Decimal-värde får inte vara över 2.0</iso:assert>
    </iso:rule>
  </iso:pattern>
</iso:schema>