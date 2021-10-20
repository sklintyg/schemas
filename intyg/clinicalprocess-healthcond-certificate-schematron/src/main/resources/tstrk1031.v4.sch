<?xml version="1.0" encoding="utf-8"?>
<iso:schema
      xmlns="http://purl.oclc.org/dsdl/schematron"
      xmlns:iso="http://purl.oclc.org/dsdl/schematron"
      queryBinding='xslt2'
      schemaVersion='ISO19757-3'>

  <iso:title>Schematron file for "Läkarintyg diabetes avseende lämpligheten att inneha körkort m.m." - Version 4.</iso:title>

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
      <iso:assert test="count(gn:svar[@id='35']) = 1">
        Ett 'MU' måste ha en 'År då diabetesdiagnosen ställdes'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='18']) = 1">
        <!-- Either 18.1 or 18.2 must be set -->
        Ett 'MU' måste ha en 'Typ av diabetes'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='207']) = 1">
        Ett 'MU' måste ha en 'Medicinering för diabetes'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='109']) = 1">
        Ett 'MU' måste ha minst en 'Behandling för diabetes'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='41']) le 1">
        Ett 'MU' får ha högst ett 'Behandling för diabetes'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='37']) le 1">
        Ett 'MU' får ha högst ett 'Förekomst av hypoglykemier med tecken på nedsatt hjärnfunktion som kan innebära en trafiksäkerhetsrisk '
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='100']) le 1">
        Ett 'MU' får ha högst ett 'Diabetessjukdomen är under kontroll avseende hypoglykemi'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='110']) le 1">
        Ett 'MU' får ha högst ett 'Har förmåga att känna varningstecken'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='106']) le 1">
        Ett 'MU' får ha högst ett 'Återkommande allvarlig hypoglykemi under det senaste året'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='107']) le 1">
        Ett 'MU' får ha högst ett 'Återkommande allvarlig hypoglykemi i vaket tillstånd under de senaste tre månaderna'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='108']) le 1">
        Ett 'MU' får ha högst ett 'Allvarlig hypoglykemi i trafiken under det senaste året'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='103']) = 1">
        Ett 'MU' måste ha ett 'Proliferativ retinopati, genomgången laserbehandling av retinopati,
        signifikant makulaödem, annan ögonsjukdom eller ögonbottenfoto som ger misstanke
        om sådan ögonsjukdom'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='8']) le 1">
        Ett 'MU' får ha högst ett 'Synskärpa'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='32']) le 1">
        Ett 'MU' får ha högst ett 'Övriga kommentarer'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='33']) ge 1 and count(gn:svar[@id='1']) le 16">
        Ett 'MU' måste ha mellan 1 och 16 'Uppfyller krav för behörighet'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='45']) le 1">
        Ett 'MU' får ha högst ett 'Lämplig att inneha behörighet med hänsyn till aktuella körningar och arbetsformer'
      </iso:assert>

      <iso:let name="svarsIdExpr" value="'^[128]$|18$|3[23457]$|4[15]$|10[036789]$|110$|20[78]$'"/>
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

  <iso:pattern id="q35">
    <iso:rule context="//gn:svar[@id='35']">
      <iso:let name="delsvarsIdExpr" value="'^35\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='35.1']) = 1">
        'År då diabetesdiagnosen ställdes' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='35.1']">
      <iso:extends rule="partial-date-year"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q18">
    <iso:rule context="//gn:svar[@id='18']">
      <iso:let name="delsvarsIdExpr" value="'^18\.1$|^18\.2$'"/>
      <iso:assert test="count(gn:delsvar[@id=18.1]) le 1">
        'Typ av diabetes' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=18.2]) le 1">
        'Beskrivning annan diabetes' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='18.1']">
      <iso:extends rule="cv"/>
      <iso:assert test="tp:cv/tp:codeSystem = '1.2.752.116.1.1.1.1.3'">
        'codeSystem' måste vara '1.2.752.116.1.1.1.1.3'.
      </iso:assert>
      <iso:assert test="matches(normalize-space(tp:cv/tp:code), '^E10$|^E11$|^E109$')">
        'Typ av diabetes' kan ha ett av värdena E10, E11 eller E109.
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='18.2']">
      <iso:extends rule="non-empty-string"/>
      <iso:assert test="string-length(normalize-space(text())) le 53">
        'Beskrivning annan diabetes' får inte överskrida 53 tecken.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q207">
    <iso:rule context="//gn:svar[@id='207']">
      <iso:let name="delsvarsIdExpr" value="'^207\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id=207.1]) le 1">
        'Medicinering för diabetes' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='207.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q208">
    <iso:rule context="//gn:svar[@id='208']">
      <iso:let name="delsvarsIdExpr" value="'^208\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id=208.1]) le 1">
        'Medicinering medför risk för hypoglykemi' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='208.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q109">
    <iso:rule context="//gn:svar[@id='109']">
      <iso:let name="delsvarsIdExpr" value="'^109\.1$|^109\.2$|^109\.3$|^109\.4$|^109\.5$|^109\.6$|^109\.7$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=109.1]) le 1">
        'Kostbehandling' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=109.2]) le 1">
        'Tablettbehandling' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=109.3]) le 1">
        'Insulinbehandling' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=109.4]) le 1">
        'Insulinbehandling sedan år' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=109.5]) le 1">
        'Annan behandling' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=109.6]) le 1">
        'Annan behandling beskriven' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=109.7]) le 1">
        'Behandling ger risk för hypoglykemi' får ha högst ett delsvar
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='109.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='109.2']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='109.3']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='109.4']">
      <iso:extends rule="partial-date-year"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='109.5']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='109.6']">
      <iso:extends rule="non-empty-string"/>
      <iso:assert test="string-length(normalize-space(text())) le 53">
        'Annan behandling beskriven' får inte överskrida 53 tecken.
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='109.7']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q41">
    <iso:rule context="//gn:svar[@id='41']">
      <iso:let name="delsvarsIdExpr" value="'^41\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='41.1']) = 1">
        'Egenkontroller av blodsocker' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='41.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q37">
    <iso:rule context="//gn:svar[@id='37']">
      <iso:let name="delsvarsIdExpr" value="'^37\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id=37.1]) = 1">
        'Förekomst av hypoglykemier med tecken på nedsatt hjärnfunktion som kan innebära en trafiksäkerhetsrisk' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='@37.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q100">
    <iso:rule context="//gn:svar[@id='100']">
      <iso:let name="delsvarsIdExpr" value="'^100\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='100.1']) = 1">
        'Diabetessjukdomen är under kontroll avseende hypoglykemi' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='100.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q110">
    <iso:rule context="//gn:svar[@id='110']">
      <iso:let name="delsvarsIdExpr" value="'^110\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='110.1']) = 1">
        'Har förmåga att känna varningstecken' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='110.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q106">
    <iso:rule context="//gn:svar[@id='106']">
      <iso:let name="delsvarsIdExpr" value="'^106\.1$|^106\.2$'"/>
      <iso:assert test="count(gn:delsvar[@id=106.1]) = 1">
        'Förekomst av återkommande allvarlig hypoglykemi under det senaste året' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=106.2]) le 1">
        'Senaste tidpunkt för återkommande allvarlig hypoglykemi' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='106.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='106.2']">
      <iso:extends rule="partial-date"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q107">
    <iso:rule context="//gn:svar[@id='107']">
      <iso:let name="delsvarsIdExpr" value="'^107\.1$|^107\.2$'"/>
      <iso:assert test="count(gn:delsvar[@id=107.1]) = 1">
        'Förekomst av återkommande allvarlig hypoglykemi i vaket tillstånd under de senaste tre månaderna' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=107.2]) le 1">
        'Senaste tidpunkt för återkommande allvarlig hypoglykemi i vaket tillstånd' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='107.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='107.2']">
      <iso:extends rule="partial-date"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q108">
    <iso:rule context="//gn:svar[@id='108']">
      <iso:let name="delsvarsIdExpr" value="'^108\.1$|^108\.2$'"/>
      <iso:assert test="count(gn:delsvar[@id=108.1]) = 1">
        'Förekomst av allvarlig hypoglykemi i trafiken under det senaste året' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=108.2]) le 1">
        'Senaste tidpunkt för allvarlig hypoglykemi i trafiken' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='108.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='108.2']">
      <iso:extends rule="partial-date"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q103">
    <iso:rule context="//gn:svar[@id='103']">
      <iso:let name="delsvarsIdExpr" value="'^103\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id=103.1]) = 1">
        'Proliferativ retinopati, genomgången laserbehandling av retinopati, signifikant makulaödem, annan ögonsjukdom eller ögonbottenfoto som ger misstanke om sådan ögonsjukdom' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='103.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q8">
    <iso:rule context="//gn:svar[@id='8']">
      <iso:let name="delsvarsIdExpr" value="'^8\.1$|^8\.2$|^8\.3$|^8\.4$|^8\.5$|^8\.6$|^8\.7$'"/>
      <iso:assert test="count(gn:delsvar[@id=8.1]) le 1">
        'Uppgifter om synskärpa skickas separat' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=8.2]) le 1">
        'Höger öga utan korrektion' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=8.3]) le 1">
        'Vänster öga utan korrektion' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=8.4]) le 1">
        'Binokulärt utan korrektion' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=8.5]) le 1">
        'Höger öga med korrektion' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=8.6]) le 1">
        'Vänster öga med korrektion' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id=8.7]) le 1">
        'Binokulärt med korrektion' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='8.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='8.2']">
      <iso:extends rule="decimal-le-2"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='8.3']">
      <iso:extends rule="decimal-le-2"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='8.4']">
      <iso:extends rule="decimal-le-2"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='8.5']">
      <iso:extends rule="decimal-le-2"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='8.6']">
      <iso:extends rule="decimal-le-2"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='8.7']">
      <iso:extends rule="decimal-le-2"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q32">
    <iso:rule context="//gn:svar[@id='32']">
      <iso:let name="delsvarsIdExpr" value="'^32\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='32.1']) = 1">
        'Övriga kommentarer' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='32.1']">
      <iso:extends rule="non-empty-string"/>
      <iso:assert test="string-length(normalize-space(text())) le 189">
        'Övriga kommentarer' får inte överskrida 189 tecken.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q33">
    <iso:rule context="//gn:svar[@id='33']">
      <iso:let name="delsvarsIdExpr" value="'^33\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id=33.1]) = 1">
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
        'Uppfyller krav för behörighet' kan ha ett av värdena VAR1 - VAR9 eller VAR11 - VAR18.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q45">
    <iso:rule context="//gn:svar[@id='45']">
      <iso:let name="delsvarsIdExpr" value="'^45\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='45.1']) = 1">
        'Lämplig att inneha behörighet med hänsyn till aktuella körningar och arbetsformer' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='45.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q34">
    <iso:rule context="//gn:svar[@id='34']">
      <iso:let name="delsvarsIdExpr" value="'^34\.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='34.1']) = 1">
        'Bör undersökas av specialistläkare' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='34.1']">
      <iso:extends rule="non-empty-string"/>
      <iso:assert test="string-length(normalize-space(text())) le 71">
        'Bör undersökas av specialistläkare' Får inte överskrida 71 tecken.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <!--#####
# Rules #
######-->

  <iso:pattern id="R1">
    <iso:rule context="//gn:delsvar[@id='1.1' and matches(normalize-space(tp:cv/tp:code), '^IAV[1-9]$')]">
      <iso:assert test="count(../../gn:svar[@id='45']/gn:delsvar[@id='45.1']) = 1">
        Om 'Intyget avser behörighet' har något av värdena IAV1 - IAV9, måste även 'Lämplig att inneha behörighet med hänsyn till aktuella körningar och arbetsformer' besvaras.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R2">
    <iso:rule context="//gn:delsvar[@id='35.1']">
      <iso:let name="currYear" value="year-from-date(current-date())"/>
      <iso:let name="personId" value="//gn:person-id/tp:extension" />
      <iso:let name="birthYear" value="substring($personId,1,4)" />
      <iso:assert test="number($birthYear) le number(tp:partialDate/tp:value)">
        Årtal i delsvar 'År då diabetesdiagnosen ställdes' måste vara ett årtal som inte är tidigare än det år patienten är född.
      </iso:assert>
      <iso:assert test="number(tp:partialDate/tp:value) le $currYear">
        Årtal i delsvar 'År då diabetesdiagnosen ställdes' måste vara innevarande år eller tidigare.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R3">
    <iso:rule context="//gn:delsvar[@id='18.1']">
      <iso:assert test="count(../gn:delsvar[@id=18.2]) = 0">
        Om 'Typ av diabetes' (DFR 18.1) besvaras med 'Annan' ska 'Beskrivning annan diabetes' (DFR 18.2) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:svar[@id='18.2']">
      <iso:assert test="count(../gn:delsvar[@id=18.1]) = 0">
        Om 'Beskrivning annan diabetes' (DFR 18.2) är besvarad  skall 'Typ av diabetes' (DFR 18.1) inte ha något värde.
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:svar[@id='18' and count(gn:delsvar[@id=18.1]) = 0]">
      <iso:assert test="count(gn:delsvar[@id=18.2]) = 1">
        Om 'Typ av diabetes' (DFR 18.1) besvaras med 'Annan' ska 'Beskrivning annan diabetes' (DFR 18.2) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R4">
    <iso:rule context="//gn:svar[@id='109']">
      <iso:assert test="count(gn:delsvar[@id=109.1 and matches(normalize-space(.), 'true|1')]) = 1 or
                        count(gn:delsvar[@id=109.2 and matches(normalize-space(.), 'true|1')]) = 1 or
                        count(gn:delsvar[@id=109.3 and matches(normalize-space(.), 'true|1')]) = 1 or
                        count(gn:delsvar[@id=109.5 and matches(normalize-space(.), 'true|1')]) = 1">
        Minst en av frågorna 'Kostbehandling' (DFR 109.1), 'Tablettbehandling' (DFR 109.2), 'Insulinbehandling' (DFR 109.3), 'Annan behandling' (DFR 109.5) måste besvaras.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R5-R6">
    <iso:rule context="//gn:delsvar[@id='109.3' and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(//gn:delsvar[@id=109.4]) = 1">
        Om 'Insulinbehandling' (DFR 109.3) besvaras måste 'Insulinbehandling sedan år' (DFR 109.4) ha ett värde.
      </iso:assert>
      <iso:assert test="count(//gn:delsvar[@id=41.1]) = 1 and
                        count(//gn:delsvar[@id=37.1]) = 1">
        Om 'Insulinbehandling' (DFR 109.3) besvaras måste 'Egenkontroller av blodsocker' (DFR 41.1) och 'Förekomst av hypoglykemier med tecken på nedsatt hjärnfunktion som kan innebära en trafiksäkerhetsrisk' (DFR 37.1) ha ett svar.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R7">
    <iso:rule context="//gn:delsvar[@id='109.4']">
      <iso:let name="currYear" value="year-from-date(current-date())"/>
      <iso:let name="personId" value="//gn:person-id/tp:extension" />
      <iso:let name="birthYear" value="substring($personId,1,4)" />
      <iso:assert test="number($birthYear) le number(tp:partialDate/tp:value)">
        Årtal i delsvar 'Insulinbehandling sedan år' måste vara ett årtal som inte är tidigare än det år patienten är född.
      </iso:assert>
      <iso:assert test="number(tp:partialDate/tp:value) le $currYear">
        Årtal i delsvar 'Insulinbehandling sedan år' måste vara innevarande år eller tidigare.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R8">
    <iso:rule context="//gn:delsvar[@id='106.1' and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(//gn:delsvar[@id=106.2]) = 1">
        Om 'Förekomst av återkommande allvarlig hypoglykemi under det senaste året' (DFR 106.1) besvaras med 'Ja' ska 'Senaste tidpunkt för återkommande allvarlig hypoglykemi' (DFR 106.2) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R9">
    <iso:rule context="//gn:delsvar[@id='107.1' and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(//gn:delsvar[@id=107.2]) = 1">
        Om 'Förekomst av återkommande allvarlig hypoglykemi i vaket tillstånd under de senaste tre månaderna' (DFR 107.1) besvaras med 'Ja' ska 'Senaste tidpunkt för återkommande allvarlig hypoglykemi i vaket tillstånd' (DFR 107.2) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R10">
    <iso:rule context="//gn:delsvar[@id='108.1' and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(//gn:delsvar[@id=108.2]) = 1">
        Om 'Förekomst av allvarlig hypoglykemi i trafiken under det senaste året ' (DFR 108.1) besvaras med 'Ja' ska 'Senaste tidpunkt för allvarlig hypoglykemi i trafiken' (DFR 108.2) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <!-- R11 shows alert message in GUI -->

  <iso:pattern id="R12">
    <iso:rule context="//gn:delsvar[@id='103.1' and matches(normalize-space(.), 'false|0')]">
      <iso:assert test="count(../../gn:svar[@id='8']) = 1">
        Om 'Proliferativ retinopati, genomgången laserbehandling av retinopati,
        signifikant makulaödem, annan ögonsjukdom eller ögonbottenfoto som ger misstanke
        om sådan ögonsjukdom' (DFR 103.1) besvaras med 'Nej' ska 'Synskärpa ' (FRG 8) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R13">
    <iso:rule context="//gn:delsvar[@id='8.4' and number(.) &lt; 0.5
                          and (count(../../gn:svar[@id='1']/gn:delsvar[@id='1.1' and matches(normalize-space(./tp:cv/tp:code), '^IAV1[1-7]$')]) &gt;= 1)]">
      <iso:assert test="count(../../gn:svar[@id='8']/gn:delsvar[@id='8.5']) = 1
                          and count(../../gn:svar[@id='8']/gn:delsvar[@id='8.6']) = 1
                          and count(../../gn:svar[@id='8']/gn:delsvar[@id='8.7']) = 1">
        Om frågan "Intyget avser behörighet (Delsvar)" (DFR 1.1) besvarats med något av valen "AM, A1, A2, A, B, BE eller Traktor"
        OCH
        frågan "Binokulärt utan korrektion (Delsvar)" (DFR 8.4) har besvarats med ett värde som är &lt; 0,5
        är (DFR 8.5), (DFR 8.6) och (DFR 8.7) obligatoriska att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R14">
    <iso:rule context="//gn:delsvar[@id='8.2' and number(.) &lt; 0.8
                          and (number(../gn:delsvar[@id='8.3']) &lt; 0.8)
                          and (count(../../gn:svar[@id='1']/gn:delsvar[@id='1.1' and matches(normalize-space(./tp:cv/tp:code), '^IAV[1-9]$')]) &gt;= 1)]">
      <iso:assert test="count(../../gn:svar[@id='8']/gn:delsvar[@id='8.5']) = 1
                          and count(../../gn:svar[@id='8']/gn:delsvar[@id='8.6']) = 1
                          and count(../../gn:svar[@id='8']/gn:delsvar[@id='8.7']) = 1">

        Om frågan "Intyget avser behörighet (Delsvar)" (DFR 1.1) besvarats med något av valen "C1, C1E, C, CE, D1, D1E, D, DE eller Taxi"
        OCH
        frågan "Höger öga utan korrektion (Delsvar)" (DFR 8.2) har besvarats med ett värde som är &lt; 0,8
        OCH
        frågan "Vänster öga utan korrektion (Delsvar)" (DFR 8.3) har besvarats med ett värde som är &lt; 0,8
        är (DFR 8.5), (DFR 8.6) och (DFR 8.7) obligatoriska att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R15">
    <iso:rule context="//gn:delsvar[@id='8.2' and number(.) &lt; 0.1
                          and (count(../../gn:svar[@id='1']/gn:delsvar[@id='1.1' and matches(normalize-space(./tp:cv/tp:code), '^IAV[1-9]$')]) &gt;= 1)]">
      <iso:assert test="count(../../gn:svar[@id='8']/gn:delsvar[@id='8.5']) = 1
                          and count(../../gn:svar[@id='8']/gn:delsvar[@id='8.6']) = 1
                          and count(../../gn:svar[@id='8']/gn:delsvar[@id='8.7']) = 1">

        Om frågan "Intyget avser behörighet (Delsvar)" (DFR 1.1) besvarats med något av valen "C1, C1E, C, CE, D1, D1E, D, DE eller Taxi"
        OCH frågan "Höger öga utan korrektion (Delsvar)" (DFR 8.2) har besvarats med ett värde som är &lt; 0,1 ELLER frågan "Vänster öga
        utan korrektion (Delsvar)" (DFR 8.3) har besvarats med ett värde som är &lt; 0,1 är (DFR 8.5), (DFR 8.6) och (DFR 8.7) obligatoriska
        att besvara.
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='8.3' and number(.) &lt; 0.1
                          and (count(../../gn:svar[@id='1']/gn:delsvar[@id='1.1' and matches(normalize-space(./tp:cv/tp:code), '^IAV[1-9]$')]) &gt;= 1)]">
      <iso:assert test="count(../../gn:svar[@id='8']/gn:delsvar[@id='8.5']) = 1
                          and count(../../gn:svar[@id='8']/gn:delsvar[@id='8.6']) = 1
                          and count(../../gn:svar[@id='8']/gn:delsvar[@id='8.7']) = 1">

        Om frågan "Intyget avser behörighet (Delsvar)" (DFR 1.1) besvarats med något av valen "C1, C1E, C, CE, D1, D1E, D, DE eller Taxi"
        OCH frågan "Höger öga utan korrektion (Delsvar)" (DFR 8.2) har besvarats med ett värde som är &lt; 0,1 ELLER frågan "Vänster öga
        utan korrektion (Delsvar)" (DFR 8.3) har besvarats med ett värde som är &lt; 0,1
        är (DFR 8.5), (DFR 8.6) och (DFR 8.7) obligatoriska att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R16">
    <iso:rule context="//gn:delsvar[@id=109.2 and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(//gn:delsvar[@id=109.7]) = 1">
        Om frågan "Tablettbehandling (Delsvar)" (DFR 109.2) ELLER frågan "Annan behandling (Delsvar)" (DFR 109.5) besvaras ska frågan  "Behandling ger risk för hypoglykemi (Delsvar)" (DFR 109.7) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id=109.5 and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(//gn:delsvar[@id=109.7]) = 1">
        Om frågan "Tablettbehandling (Delsvar)" (DFR 109.2) ELLER frågan "Annan behandling (Delsvar)" (DFR 109.5) besvaras ska frågan  "Behandling ger risk för hypoglykemi (Delsvar)" (DFR 109.7) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R17">
    <iso:rule context="//gn:delsvar[@id=109.7 and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(../../gn:svar[@id='41']) = 1
                        and count(../../gn:svar[@id='37']) = 1">
        Om "Behandling ger risk för hypoglykemi (Delsvar)" (DFR 109.7) besvaras med "Ja" ska följande frågor vara obligatoriska att besvara:
        Egenkontroller av blodsocker (Delsvar) (FRG 41)
        Förekomst av hypoglykemier med tecken på nedsatt hjärnfunktion som kan innebära en trafiksäkerhetsrisk (Delsvar) (FRG 37)
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R18">
    <iso:rule context="//gn:delsvar[@id=109.5 and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(../gn:delsvar[@id=109.6]) = 1">
        Om frågan "Annan behandling (Delsvar)" (DFR 109.5) besvaras ska frågan  "Annan behandling beskrivning (Delsvar)" (DFR 109.6) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <!-- R19 is validated in id=q8 -->

  <iso:pattern id="R20-R21-R22">
    <iso:let name="currDate" value="xs:date(current-date())"/>
    <iso:let name="personId" value="//gn:person-id/tp:extension" />
    <!-- Handle samordningsnummer -->
    <iso:let name="birthDay" value="if (substring($personId,7,2) lt '60') then substring($personId,7,2) else xs:string(xs:integer(substring($personId,7,2)) - 60)" />
    <iso:let name="birthDate" value="xs:date(string-join((substring($personId,1,4),substring($personId,5,2),$birthDay), '-'))"/>

    <iso:rule context="//gn:delsvar[@id='106.2']">
      <iso:let name="dateValue" value="xs:date(tp:partialDate/tp:value)"/>
      <iso:assert test="$dateValue le $currDate">
        Datum som anges i delfråga 'DFR 106.2' får inte vara senare än dagens datum.
      </iso:assert>
      <iso:assert test="$birthDate le $dateValue">
        Datum i delsvar delfråga 'DFR 106.2' måste vara ett datum som inte är tidigare än det datum patienten är född.
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='107.2']">
      <iso:let name="dateValue" value="xs:date(tp:partialDate/tp:value)"/>
      <iso:assert test="$dateValue le $currDate">
        Datum som anges i delfråga 'DFR 107.2' får inte vara senare än dagens datum.
      </iso:assert>
      <iso:assert test="$birthDate le $dateValue">
        Datum i delsvar delfråga 'DFR 107.2' måste vara ett datum som inte är tidigare än det datum patienten är född.
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='108.2']">
      <iso:let name="dateValue" value="xs:date(tp:partialDate/tp:value)"/>
      <iso:assert test="$dateValue le $currDate">
        Datum som anges i delfråga 'DFR 108.2' får inte vara senare än dagens datum.
      </iso:assert>
      <iso:assert test="$birthDate le $dateValue">
        Datum i delsvar delfråga 'DFR 108.2' måste vara ett datum som inte är tidigare än det datum patienten är född.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R23-R24">
    <iso:rule context="//gn:delsvar[@id='33.1' and matches(normalize-space(tp:cv/tp:code), '^VAR11$')]">
      <iso:assert test="count(../../gn:svar[@id='33']) = 1">
        Om frågan "Uppfyller krav för behörighet (Delsvar)" (DFR 33.1) besvaras med "kan inte ta ställning" får inga andra svar anges i frågan.
        OCH
        Om frågan "Uppfyller krav för behörighet (Delsvar)" (DFR 33.1) besvaras med något annat värde än "kan inte ta ställning" kan värdet "kan inte ta ställning" inte också anges.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R25">
    <iso:rule context="//gn:delsvar[@id='37.1' and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(../../gn:svar[@id='100']) = 1
                        and count(../../gn:svar[@id='110']) = 1
                        and count(../../gn:svar[@id='106']) = 1
                        and count(../../gn:svar[@id='107']) = 1
                        and count(../../gn:svar[@id='108']) = 1">
        Om frågan "Förekomst av hypoglykemier med tecken på nedsatt hjärnfunktion som kan innebära en trafiksäkerhetsrisk (Delsvar)" (DFR 37.1) besvaras med "Ja" ska följande frågor vara obligatoriska att besvara:

        Diabetessjukdomen är under kontroll avseende hypoglykemi (Svar) (FRG 100)
        Har förmåga att känna varningstecken (Svar) (FRG 110)
        Allvarlig återkommande hypoglykemi under det senaste året (Svar) (FRG 106)
        Allvarlig återkommande hypoglykemi i vaket tillstånd under de senaste tre månaderna (Svar) (FRG 107)
        Allvarlig hypoglykemi i trafiken under det senaste året (Svar) (FRG 108)
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R26">
    <iso:rule context="//gn:delsvar[@id=8.1 and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(//gn:delsvar[@id=8.2]) = 0
                         and count(//gn:delsvar[@id=8.3]) = 0
                         and count(//gn:delsvar[@id=8.4]) = 0
                         and count(//gn:delsvar[@id=8.5]) = 0
                         and count(//gn:delsvar[@id=8.6]) = 0
                         and count(//gn:delsvar[@id=8.7]) = 0">
        Om rutan ”Uppgifter om synskärpa skickas separat” fylls i behöver inte uppgifter om synskärpa fyllas i.
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:svar[@id=8 and (count(gn:delsvar[@id=8.1]) = 0 or matches(gn:delsvar[@id=8.1], 'false|0'))]">
      <iso:assert test="count(gn:delsvar[@id=8.2]) = 1
                         or count(gn:delsvar[@id=8.3]) = 1
                         or count(gn:delsvar[@id=8.4]) = 1
                         or count(gn:delsvar[@id=8.5]) = 1
                         or count(gn:delsvar[@id=8.6]) = 1
                         or count(gn:delsvar[@id=8.7]) = 1">
        Om uppgift om synskärpa utan korrektion fylls i, i enlighet med satta valideringsregler,  behöver inte rutan ”intyg skickas separat” fyllas i.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R32">
    <iso:rule context="//gn:delsvar[@id=207.1 and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(//gn:delsvar[@id='208.1']) = 1">
        Om 'Medicinering för diabetes' (DFR 207.1) besvaras med 'Ja' måste 'Medicinering medför risk för hypoglykemi' (DFR 208.1) ha ett värde.
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

  <iso:pattern id="partial-date-pattern">
    <iso:rule id="partial-date" abstract="true">
      <iso:assert test="tp:partialDate/tp:value/count(*) = 0">Datum får inte vara inbäddat i något element.</iso:assert>
      <iso:assert test="tp:partialDate/tp:value castable as xs:date">Värdet måste vara ett giltigt datum.</iso:assert>
      <iso:assert test="matches(tp:partialDate/tp:value, '^\d{4}-\d{2}-\d{2}')">Datumet måste uttryckas som YYYY-MM-DD.</iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="partial-date-year-pattern">
    <iso:rule id="partial-date-year" abstract="true">
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
      <iso:assert test="abs(.) le 2.0">Decimal-värde får inte vara över 2.0</iso:assert>
    </iso:rule>
  </iso:pattern>
</iso:schema>
