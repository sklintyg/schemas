<?xml version="1.0" encoding="utf-8"?>
<iso:schema
      xmlns="http://purl.oclc.org/dsdl/schematron"
      xmlns:iso="http://purl.oclc.org/dsdl/schematron"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://purl.oclc.org/dsdl/schematron"
      queryBinding='xslt2'
      schemaVersion='ISO19757-3'>

  <iso:title>Schematron file for "Läkarintyg diabetes avseende lämpligheten att inneha körkort m.m." - Version 2.</iso:title>

  <iso:ns prefix="xs" uri="http://www.w3.org/2001/XMLSchema"/>
  <iso:ns prefix="rg" uri="urn:riv:clinicalprocess:healthcond:certificate:RegisterCertificateResponder:3"/>
  <iso:ns prefix="gn" uri="urn:riv:clinicalprocess:healthcond:certificate:3"/>
  <iso:ns prefix="tp" uri="urn:riv:clinicalprocess:healthcond:certificate:types:3"/>

  <iso:pattern id="global-texts">
    <iso:let name="svar1" value="'Intyget avser behörighet (svar)'"/>
    <iso:let name="svar1_1" value="'Intyget avser behörighet (delsvar)'"/>
    <iso:let name="svar2" value="'Identitet styrkt genom (svar)'"/>
    <iso:let name="svar2_1" value="'Identitet styrkt genom (delsvar)'"/>
    <iso:let name="svar35" value="'År då diabetesdiagnosen ställdes (Svar)'"/>
    <iso:let name="svar35_1" value="'År då diabetesdiagnosen ställdes (Delsvar)'"/>
    <iso:let name="svar18" value="'Typ av diabetes (Svar)'"/>
    <iso:let name="svar18_1" value="'Typ av diabetes (Svar)'"/>
    <iso:let name="svar18_2" value="'Beskrivning annan diabetes (Svar)'"/>
    <iso:let name="svar109" value="'Behandling för diabetes (Svar)'"/>
    <iso:let name="svar109_1" value="'Kostbehandling (delsvar)'"/>
    <iso:let name="svar109_2" value="'Tablettbehandling (delsvar)'"/>
    <iso:let name="svar109_3" value="'Tablettbehandling ger risk för hypoglykemi (Delsvar)'"/>
    <iso:let name="svar109_4" value="'Insulinbehandling (delsvar)'"/>
    <iso:let name="svar109_5" value="'Insulinbehandling sedan åt (Delsvar)'"/>
    <iso:let name="svar109_6" value="'Annan behandling (Delsvar)'"/>
    <iso:let name="svar109_7" value="'Annan behandling beskriven (Delsvar)'"/>
    <iso:let name="svar100" value="'Diabetessjukdomen är under kontroll avseende hypoglykemi (Svar)'"/>
    <iso:let name="svar100_1" value="'Diabetessjukdomen är under kontroll avseende hypoglykemi (Delsvar)'"/>
    <iso:let name="svar37" value="'Förekomst av hypoglykemier med tecken på nedsatt hjärnfunktion som kan innebära en trafiksäkerhetsrisk (Svar)'"/>
    <iso:let name="svar37_1" value="'Förekomst av hypoglykemier med tecken på nedsatt hjärnfunktion som kan innebära en trafiksäkerhetsrisk (Delsvar)'"/>
    <iso:let name="svar101" value="'Förstår risker förknippade med hypoglykemi (Svar)'"/>
    <iso:let name="svar101_1" value="'Förstår risker förknippade med hypoglykemi (Delsvar)'"/>
    <iso:let name="svar102" value="'Är väl förtrogen med symptomen på hypoglykemi (Svar)'"/>
    <iso:let name="svar102_1" value="'Är väl förtrogen med symptomen på hypoglykemi (Delsvar)'"/>
    <iso:let name="svar38" value="'Saknar förmåga att känna varningstecken (Svar)'"/>
    <iso:let name="svar38_1" value="'Saknar förmåga att känna varningstecken (Delsvar)'"/>
    <iso:let name="svar36" value="'Kunskap om lämpliga åtgärder vid hypoglykemi (Svar)'"/>
    <iso:let name="svar36_1" value="'Kunskap om lämpliga åtgärder vid hypoglykemi (Delsvar)'"/>
    <iso:let name="svar105" value="'Egenkontroller av blodsocker (Svar)'"/>
    <iso:let name="svar105_1" value="'Egenkontroller av blodsocker (Delsvar)'"/>
    <iso:let name="svar106" value="'Senaste tidpunkt för allvarlig hypoglykemi (Delsvar)'"/>
    <iso:let name="svar106_1" value="'Allvarlig återkommande hypoglykemi i vaket tillstånd under de senaste tre månaderna (Svar)'"/>
    <iso:let name="svar106_2" value="'Senaste tidpunkt för allvarlig hypoglykemi (Delsvar)'"/>
    <iso:let name="svar107" value="'Allvarlig återkommande hypoglykemi i vaket tillstånd under de senaste tre månaderna (Svar)'"/>
    <iso:let name="svar107_1" value="'Förekomst av allvarlig återkommande hypoglykemi under det senaste året (Delsvar)'"/>
    <iso:let name="svar107_2" value="'Senaste tidpunkt för allvarlig hypoglykemi i vaket tillstånd (Delsvar)'"/>
    <iso:let name="svar108" value="'Allvarlig hypoglykemi i trafiken under det senaste året (Svar)'"/>
    <iso:let name="svar108_1" value="'Förekomst av allvarlig hypoglykemi i trafiken under det senaste året (Delsvar)'"/>
    <iso:let name="svar108_2" value="'Senaste tidpunkt för allvarlig hypoglykemi i trafiken (Delsvar)'" />
    <iso:let name="svar103" value="'Proliferativ retinopati, genomgången laserbehandling av retinopati, signifikant makulaödem, annan ögonsjukdom eller ögonbottenfoto som ger misstanke om sådan ögonsjukdom (Svar)'"/>
    <iso:let name="svar103_1" value="'Proliferativ retinopati, genomgången laserbehandling av retinopati, signifikant makulaödem, annan ögonsjukdom eller ögonbottenfoto som ger misstanke om sådan ögonsjukdom (Delsvar)'"/>
    <iso:let name="svar104" value="'Ögonbottenfoto saknas (Svar)'"/>
    <iso:let name="svar104_1" value="'Ögonbottenfoto saknas (Delsvar)'"/>
    <iso:let name="svar8" value="'Synskärpa (Svar)'"/>
    <iso:let name="svar8_1" value="'Höger öga utan korrektion (Delsvar)'"/>
    <iso:let name="svar8_2" value="'Vänster öga utan korrektion (Delsvar)'"/>
    <iso:let name="svar8_3" value="'Binokulärt utan korrektion (Delsvar)'"/>
    <iso:let name="svar8_4" value="'Höger öga med korrektion (Delsvar)'"/>
    <iso:let name="svar8_5" value="'Vänster öga med korrektion (Delsvar)  '"/>
    <iso:let name="svar8_6" value="'Binokulärt med korrektion (Delsvar) '"/>
    <iso:let name="svar32" value="'Övriga kommentarer (Svar)'"/>
    <iso:let name="svar32_1" value="'Övriga kommentarer (Delsvar)'"/>
    <iso:let name="svar33" value="'Uppfyller krav för behörighet (Svar)'"/>
    <iso:let name="svar33_1" value="'Uppfyller krav för behörighet (Delsvar)'"/>
    <iso:let name="svar34" value="'Bör undersökas av specialistläkare (Svar)'"/>
    <iso:let name="svar34_1" value="'Bör undersökas av specialistläkare (delsvar)'"/>
    <iso:let name="svar45" value="'Lämplig att inneha behörighet med hänsyn till aktuella körningar och arbetsformer (Svar)'"/>
    <iso:let name="svar45_1" value="'Lämplig att inneha behörighet med hänsyn till aktuella körningar och arbetsformer (Delsvar)'"/>
  </iso:pattern>

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
      <iso:assert test="count(gn:svar[@id='18']) le 1">
        Ett 'MU' får ha högst ett 'Typ av diabetes'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='109']) le 1">
        Ett 'MU' får ha högst ett 'Behandling för diabetes'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='100']) le 1">
        Ett 'MU' får ha högst ett 'Diabetessjukdomen är under kontroll avseende hypoglykemi'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='37']) le 1">
        Ett 'MU' får ha högst ett 'Förekomst av hypoglykemier med tecken på nedsatt hjärnfunktion som kan innebära en trafiksäkerhetsrisk '
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='101']) le 1">
        Ett 'MU' får ha högst ett 'Förstår risker förknippade med hypoglykemi'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='102']) le 1">
        Ett 'MU' får ha högst ett 'Är väl förtrogen med symptomen på hypoglykemi'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='38']) le 1">
        Ett 'MU' får ha högst ett 'Saknar förmåga att känna varningstecken'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='36']) le 1">
        Ett 'MU' får ha högst ett 'Kunskap om lämpliga åtgärder vid hypoglykemi'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='105']) le 1">
        Ett 'MU' får ha högst ett 'Egenkontroller av blodsocker'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='106']) le 1">
        Ett 'MU' får ha högst ett 'Allvarlig återkommande hypoglykemi under det senaste året'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='107']) le 1">
        Ett 'MU' får ha högst ett 'Allvarlig återkommande hypoglykemi i vaket tillstånd under de senaste tre månaderna'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='108']) le 1">
        Ett 'MU' får ha högst ett 'Allvarlig hypoglykemi i trafiken under det senaste året'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='103']) = 1">
        Ett 'MU' måste ha ett 'Proliferativ retinopati, genomgången laserbehandling av retinopati,
        signifikant makulaödem, annan ögonsjukdom eller ögonbottenfoto som ger misstanke om sådan ögonsjukdom'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='104']) = 1">
        Ett 'MU' måste ha ett 'Ögonbottenfoto saknas'
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
      <iso:assert test="count(gn:svar[@id='34']) le 1">
        Ett 'MU' får ha högst ett 'Bör undersökas av specialistläkare'
      </iso:assert>

      <iso:let name="svarsIdExpr" value="'^[128]$|18$|3[2345678]$|45$|10[0-9]$'"/>
      <iso:assert test="count(gn:svar[not(matches(@id, $svarsIdExpr))]) = 0">
        Oväntat svars-id. Svars-id:n måste matcha "<value-of select="$svarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q1">
    <iso:rule context="//gn:svar[@id='1']">
      <iso:let name="delsvarsIdExpr" value="'^1.1$'"/>
      <iso:assert test="count(gn:delsvar[@id=1.1]) = 1">
        <value-of select="$svar1"/> måste ha ett <value-of select="$svar1_1"/>
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='1.1']">
      <iso:extends rule="cv"/>

      <iso:assert test="tp:cv/tp:codeSystem = '24c41b8d-258a-46bf-a08a-b90738b28770'">'codeSystem' måste vara '24c41b8d-258a-46bf-a08a-b90738b28770'.
      </iso:assert>
      <iso:assert test="matches(normalize-space(tp:cv/tp:code), '^IAV([1-9]$|1[0-7]$)')">
        <value-of select="$svar1_1"/> kan ha ett av värdena IAV1 - IAV17.
      </iso:assert>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q2">

    <iso:rule context="//gn:svar[@id='2']">
      <iso:let name="delsvarsIdExpr" value="'^2.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='2.1']) = 1">
        <value-of select="$svar2"/> måste ha ett <value-of select="$svar2_1"/>
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvarsvar[@id='2.1']">
      <iso:extends rule="cv"/>
      <iso:assert test="tp:cv/tp:codeSystem = 'e7cc8f30-a353-4c42-b17a-a189b6876647'">
        'codeSystem' måste vara 'e7cc8f30-a353-4c42-b17a-a189b6876647'.
      </iso:assert>
      <iso:assert test="matches(normalize-space(tp:cv/tp:code), '^IAV([1-9]$|1[0-7]$)')">
        <value-of select="$svar2_1"/> kan ha ett av värdena IDK1 - IDK6.
      </iso:assert>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q35">

    <iso:rule context="//gn:svar[@id='35']">
      <iso:let name="delsvarsIdExpr" value="'^35.1$'"/>

      <iso:assert test="count(gn:delsvar[@id='35.1']) = 1">
        <value-of select="$svar35"/> måste ha ett <value-of select="$svar35_1"/>
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:svar[@id='35.1']">
      <iso:extends rule="date"/>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q18">

    <iso:rule context="//gn:svar[@id='18']">
      <iso:let name="delsvarsIdExpr" value="'^18.1$|^18.2$'"/>

      <iso:assert test="count(gn:delsvar[@id=18.1]) = 1">
        <value-of select="$svar18"/>måste ha ett <value-of select="$svar18_1"/>
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:svar[@id='18.1']">
      <iso:extends rule="cv"/>
      <iso:assert test="tp:cv/tp:codeSystem = '1.2.752.116.1.1.1.1.3'">
        'codeSystem' måste vara '1.2.752.116.1.1.1.1.3'.
      </iso:assert>
      <iso:assert test="matches(normalize-space(tp:cv/tp:code), '^E1[013]$')">
        <value-of select="$svar18_1"/> kan ha ett av värdena E10, E11 och E13.
      </iso:assert>
    </iso:rule>

    <!--R3: 18.1, 18.2-->
    <iso:rule context="//gn:delsvar[@id='18.1']/tp:cv/tp:code[normalize-space(.) = 'E13']">
      <iso:assert test="../../../gn:delsvar[@id='18.2']">
        Om "<value-of select="$svar18_1"/>" är "ANNAT" så måste "<value-of select="$svar18_2"/>" anges.
      </iso:assert>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q109">

    <iso:rule context="//gn:delsvar[@id='109.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar109_1"/>" måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='109.2']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar109_2"/>" måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='109.3']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar109_3"/>" måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='109.4']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar109_4"/>" måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='109.5']">
      <iso:extends rule="partial-date"/>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='109.6']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar109_6"/>" måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='109.7']">
      <iso:extends rule="non-empty-string"/>
    </iso:rule>

    <iso:rule context="//gn:svar[@id='109']">
      <iso:let name="delsvarsIdExpr" value="'^109.1$|^109.2$|^109.3$|^109.4$|^109.5$|^109.6$|^109.7$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <!--R4: 109.1, 109.2, 109.4, 109.6-->
    <iso:rule context="//gn:svar[@id='109']">
      <iso:assert test="count(gn:delsvar[@id='109.1']) = 1 or
                        count(gn:delsvar[@id='109.2']) = 1 or
                        count(gn:delsvar[@id='109.4']) = 1 or
                        count(gn:delsvar[@id='109.6']) = 1">
        Minst en av "<value-of select="$svar109_1"/>",
        "<value-of select="$svar109_2"/>",
        "<value-of select="$svar109_4"/>" eller
        "<value-of select="$svar109_6"/>" måste besvaras.
      </iso:assert>

    </iso:rule>

    <!--R16: 109.2-109.3-->
    <iso:rule context="//gn:svar[@id='109']">
      <iso:assert test="count(gn:delsvar[@id='109.2']) = 1 and
                        count(gn:delsvar[@id='109.3']) = 1">
        Om frågan "<value-of select="$svar109_2"/>" besvaras ska frågan
        "<value-of select="$svar109_3"/>" visas och vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>

    <!--R5: 109.4, 109.5-->
    <iso:rule context="//gn:delsvar[@id='109.4']">
      <iso:assert test="count(../gn:delsvar[@id='109.5']) = 1">
        Om "<value-of select="$svar109_4"/>" är besvaras måste även även "<value-of select="$svar109_5"/>" besvaras.
      </iso:assert>
    </iso:rule>

    <!--R16: 109.2, 109.3-->
    <iso:rule context="//gn:delsvar[@id='109.2']">
      <iso:assert test="count(../gn:delsvar[@id='109.3']) = 1">
        Om "<value-of select="$svar109_2"/>" är besvaras måste även även "<value-of select="$svar109_3"/>" besvaras.
      </iso:assert>
    </iso:rule>

    <!--R18: 109.6, 109.7-->
    <iso:rule context="//gn:delsvar[@id='109.6']">
      <iso:assert test="count(../gn:delsvar[@id='109.7']) = 1">
        Om "<value-of select="$svar109_6"/>" är besvaras måste även även "<value-of select="$svar109_7"/>" besvaras.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q100">

    <iso:rule context="//gn:svar[@id='100']">
      <iso:let name="delsvarsIdExpr" value="'^100.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='100.1']) = 1">
        "<value-of select="$svar100"/>" måste ha ett "<value-of select="$svar100_1"/>"
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='100.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar100_1"/>" måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q37">
    <iso:rule context="//gn:svar[@id='37']">
      <iso:let name="delsvarsIdExpr" value="'^37.1$'"/>
      <iso:assert test="count(gn:delsvar[@id=37.1]) = 1">
        "<value-of select="$svar37"/>" måste ha ett "<value-of select="$svar37_1"/>"
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='@37.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar37_1"/>" måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q101">

    <iso:rule context="//gn:svar[@id='101']">
      <iso:let name="delsvarsIdExpr" value="'^101.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='101.1']) = 1">
        "<value-of select="$svar101"/>" måste ha ett "<value-of select="$svar101_1"/>"
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='101.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar101_1"/>" måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q102">
    <iso:rule context="//gn:svar[@id='102']">
      <iso:let name="delsvarsIdExpr" value="'^102.1$'"/>

      <iso:assert test="count(gn:delsvar[@id=102.1]) = 1">
        "<value-of select="$svar102"/>" måste ha ett "<value-of select="$svar102_1"/>"
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='102.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar102_1"/>" måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q38">
    <iso:rule context="//gn:svar[@id='38']">
      <iso:let name="delsvarsIdExpr" value="'^38.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='38.1']) = 1">
        "<value-of select="$svar38"/>" måste ha ett "<value-of select="$svar38_1"/>"
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='38.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar38_1"/>" måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q36">
    <iso:rule context="//gn:svar[@id='36']">
      <iso:let name="delsvarsIdExpr" value="'^36.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='36.1']) = 1">
        "<value-of select="$svar36"/>" måste ha ett "<value-of select="$svar36_1"/>"
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='36.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar36_1"/>" måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q105">
    <iso:rule context="//gn:svar[@id='105']">
      <iso:let name="delsvarsIdExpr" value="'^105.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='105.1']) = 1">
        "<value-of select="$svar105"/>" måste ha ett "<value-of select="$svar105_1"/>"
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>


    <iso:rule context="//gn:delsvar[@id='105.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar105_1"/>" måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q106">
    <iso:rule context="//gn:svar[@id='106']">
      <iso:let name="delsvarsIdExpr" value="'^106.1$|^106.2$'"/>
      <iso:assert test="count(gn:delsvar[@id='106.1']) = 1">
        "<value-of select="$svar106"/>" måste ha ett "<value-of select="$svar106_1"/>"
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='106.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar106_1"/>" måste ha ett svar av typen boolean
      </iso:assert>

      <!-- R8: 106.1-106.2-->
      <iso:assert test="count(../gn:delsvar[@id=106.2]) = 1">
        Om  "<value-of select="$svar106_1"/>" är besvarat, måste även "<value-of select="$svar106_2"/>" besvaras
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='106.2']">
      <iso:extends rule="date"/>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q107">
    <iso:rule context="//gn:svar[@id='107']">
      <iso:let name="delsvarsIdExpr" value="'^107.1$|^107.2$'"/>
      <iso:assert test="count(gn:delsvar[@id='107.1']) = 1">
        "<value-of select="$svar107"/>" måste ha ett "<value-of select="$svar107_1"/>"
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='107.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar107_1"/>" måste ha ett svar av typen boolean
      </iso:assert>

      <!--R9: 107.1-107.2-->
      <iso:assert test="count(../gn:delsvar[@id='107.2']) = 1">
        Om  "<value-of select="$svar107_1"/>" är besvarat, måste även "<value-of select="$svar107_2"/>" besvaras
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='107.2']">
      <iso:extends rule="date"/>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q108">

    <iso:rule context="//gn:svar[@id='108']">
      <iso:let name="delsvarsIdExpr" value="'^108.1$|^108.2$'"/>
      <iso:assert test="count(gn:delsvar[@id='108.1']) = 1">
        "<value-of select="$svar108"/>" måste ha ett "<value-of select="$svar108_1"/>"
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='108.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar108_1"/>" måste ha ett svar av typen boolean
      </iso:assert>

      <!--R10: 108.1-108.2-->
      <iso:assert test="count(../gn:delsvar[@id='108.2']) = 1">
        Om  "<value-of select="$svar108_1"/>" är besvarat, måste även "<value-of select="$svar108_2"/>" besvaras
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='108.2']">
      <iso:extends rule="date"/>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q103">
    <iso:rule context="//gn:svar[@id='103']">
      <iso:let name="delsvarsIdExpr" value="'^103.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='103.1']) = 1">
        "<value-of select="$svar103"/>" måste ha ett "<value-of select="$svar103_1"/>"
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='103.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar103_1"/>" måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q104">
    <iso:rule context="//gn:svar[@id='104']">
      <iso:let name="delsvarsIdExpr" value="'^104.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='104.1']) = 1">
        "<value-of select="$svar104"/>" måste ha ett "<value-of select="$svar104_1"/>"
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='104.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar104_1"/>" måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q8">
    <iso:rule context="//gn:svar[@id='8']">
      <iso:let name="delsvarsIdExpr" value="'^8.1$|^8.2$|^8.3$|^8.4$|^8.5$|^8.6$'"/>
      <iso:assert test="
        count(gn:delsvar[@id='8.1']) = 1 and
        count(gn:delsvar[@id='8.2']) = 1 and
        count(gn:delsvar[@id='8.3']) = 1">
        "<value-of select="$svar8"/>" måste ha ett
        "<value-of select="$svar8_1"/>",
        "<value-of select="$svar8_2"/>" och
        "<value-of select="$svar8_3"/>",
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='8.1']">
      <iso:extends rule="decimal"/>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='8.2']">
      <iso:extends rule="decimal"/>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='8.3']">
      <iso:extends rule="decimal"/>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='8.4']">
      <iso:extends rule="decimal"/>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='8.5']">
      <iso:extends rule="decimal"/>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='8.6']">
      <iso:extends rule="decimal"/>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q32">
    <iso:rule context="//gn:svar[@id='32']">
      <iso:let name="delsvarsIdExpr" value="'^32.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='32.1']) = 1">
        "<value-of select="$svar32"/>" måste ha ett "<value-of select="$svar32_1"/>"
      </iso:assert>
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
      <iso:let name="delsvarsIdExpr" value="'^33.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='33.1']) = 1">
        <value-of select="$svar1"/>måste ha ett<value-of select="$svar1_1"/>
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='33.1']">
      <iso:extends rule="cv"/>
      <iso:assert test="tp:cv/tp:codeSystem = 'e889fa20-1dee-4f79-8b37-03853e75a9f8'"> 'codeSystem' måste vara 'e889fa20-1dee-4f79-8b37-03853e75a9f8'.
      </iso:assert>
      <iso:assert test="matches(normalize-space(tp:cv/tp:code), '^VAR([1-9]$|1[0-8]$)')">
        <value-of select="$svar33_1"/> kan ha ett av värdena IAV1 - IAV17.
      </iso:assert>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q45">

    <iso:rule context="//gn:svar[@id='45']">
      <iso:let name="delsvarsIdExpr" value="'^45.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='45.1']) = 1">
        "<value-of select="$svar45"/>" måste ha ett "<value-of select="$svar45_1"/>"
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='45.1']">
      <iso:assert test="matches(normalize-space(.), '^true$|^1$|^false$|^0$')">
        "<value-of select="$svar45_1"/>" måste ha ett svar av typen boolean
      </iso:assert>
    </iso:rule>

  </iso:pattern>

  <iso:pattern id="q34">
    <iso:rule context="//gn:svar[@id='34']">
      <iso:let name="delsvarsIdExpr" value="'^34.1$'"/>
      <iso:assert test="count(gn:delsvar[@id='34.1']) = 1">
        "<value-of select="$svar34"/>" måste ha ett "<value-of select="$svar34_1"/>"
      </iso:assert>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='34.1']">
      <iso:extends rule="non-empty-string"/>
      <iso:assert test="string-length(normalize-space(text())) le 71">
        "<value-of select="$svar34_1"/>" Får inte överskrida 71 tecken.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <!--Rules spanning multiple questions-->

  <iso:pattern id="R1-1.1-45.1">
    <iso:rule context="//gn:delsvar[@id='1.1' and matches(normalize-space(tp:cv/tp:code), '^IAV[1-8]$')]">
      <iso:assert test="count(../../gn:svar[@id='45']/gn:delsvar[@id='45.1']) = 1">
        Om "<value-of select="$svar1_1"/>" har något av värdena IAV1 - IAV8, måste även "<value-of select="$svar45_1"/>" besvaras.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R6-36.1-37.1-38.1-100.1-101.1-102.1-105.1-106.1-107.1-108.1">
    <iso:rule context="//gn:delsvar[@id='109.4']">
      <iso:assert test="count(../../gn:svar[@id='36']/gn:delsvar[@id='36.1']) = 1 and
                        count(../../gn:svar[@id='37']/gn:delsvar[@id='37.1']) = 1 and
                        count(../../gn:svar[@id='38']/gn:delsvar[@id='38.1']) = 1 and
                        count(../../gn:svar[@id='100']/gn:delsvar[@id='100.1']) = 1 and
                        count(../../gn:svar[@id='101']/gn:delsvar[@id='101.1']) = 1 and
                        count(../../gn:svar[@id='102']/gn:delsvar[@id='102.1']) = 1 and
                        count(../../gn:svar[@id='105']/gn:delsvar[@id='105.1']) = 1 and
                        count(../../gn:svar[@id='106']/gn:delsvar[@id='106.1']) = 1 and
                        count(../../gn:svar[@id='107']/gn:delsvar[@id='107.1']) = 1 and
                        count(../../gn:svar[@id='108']/gn:delsvar[@id='108.1']) = 1">

        Om "<value-of select="$svar109_4"/>" har något av värdena IAV1 - IAV8, måste även
        "<value-of select="$svar36_1"/>",
        "<value-of select="$svar37_1"/>",
        "<value-of select="$svar38_1"/>",
        "<value-of select="$svar100_1"/>",
        "<value-of select="$svar101_1"/>",
        "<value-of select="$svar102_1"/>",
        "<value-of select="$svar105_1"/>",
        "<value-of select="$svar106_1"/>",
        "<value-of select="$svar107_1"/>",
        "<value-of select="$svar108_1"/>" besvaras.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R12-103.1-104.1-8">
    <iso:rule context="//gn:svar[@id='103']/gn:delsvar[@id='103.1']">
      <iso:assert test="(matches(normalize-space(.), 'true|1') or matches(normalize-space(../../gn:svar[@id=104]/gn:delsvar[@id='104.1']), 'false|0')) and
                        (count(../../gn:svar[@id='8']) = 1)">
        Om "<value-of select="$svar103_1"/>" har värdet true, eller
        om "<value-of select="$svar104_1"/>" har värdet false,
        måste även "<value-of select="$svar8"/>" besvaras.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R13-R14-R15-1.1-8.1-8.2-8.4-8.5-8.6">

    <!--R13-->
    <iso:rule context="//gn:svar[@id='1'
                                and matches(normalize-space(gn:delsvar[@id=1.1]/tp:cv/tp:code), '^IAV1[1-7]$')
                                and abs(../gn:svar[@id=1]/gn:delsvar[@id='8.3']) lt 0.5]">
      <iso:assert test="count(../gn:svar[@id='8']/gn:delsvar[@id='8.5']) = 1 and
                        count(../gn:svar[@id='8']/gn:delsvar[@id='8.6']) = 1">

        Om frågan "<value-of select="$svar1_1"/>" besvarats med något av valen "IAV11 - IAV17"
        OCH frågan "<value-of select="$svar8_3"/>" har besvarats med ett värde som är mindre än 0,5 är
        "<value-of select="$svar8_4"/>", "<value-of select="$svar8_5"/>" och "<value-of select="$svar8_6"/>" obligatoriska att besvara.
      </iso:assert>
    </iso:rule>

    <!--R14-->
    <iso:rule context="//gn:svar[@id='1'
                                and matches(normalize-space(gn:delsvar[@id=1.1]/tp:cv/tp:code), '^IAV1[1-9]$')
                                and abs(../gn:svar[@id=1]/gn:delsvar[@id='8.1']) lt 0.8
                                and abs(../gn:svar[@id=1]/gn:delsvar[@id='8.2']) lt 0.8]">
      <iso:assert test="count(../gn:svar[@id='8']/gn:delsvar[@id='8.4']) = 1 and
                        count(../gn:svar[@id='8']/gn:delsvar[@id='8.5']) = 1 and
                        count(../gn:svar[@id='8']/gn:delsvar[@id='8.6']) = 1">

        Om frågan "<value-of select="$svar1_1"/>" besvarats med något av valen IAV1 - IAV9
        OCH frågan "<value-of select="$svar8_1"/>" har besvarats med ett värde som är mindre än 0,8
        OCH frågan "Vänster öga utan korrektion (Delsvar)" (DFR 8.2) har besvarats med ett värde som är mindre än 0,8
        är "<value-of select="$svar8_4"/>", "<value-of select="$svar8_5"/>" och "<value-of select="$svar8_6"/>" obligatoriska att besvara.

      </iso:assert>
    </iso:rule>

    <!--R15: 1.1-8.1-8.2-8.4-8.5-8.6-->
    <iso:rule context="//gn:svar[@id='1'
                                 and matches(normalize-space(gn:delsvar[@id=1.1]/tp:cv/tp:code), '^IAV1[1-9]$')
                                 and abs(../gn:svar[@id=1]/gn:delsvar[@id='8.1']) lt 0.1
                                 and abs(../gn:svar[@id=1]/gn:delsvar[@id='8.2']) lt 0.1]">
      <iso:assert test="count(../gn:svar[@id='8']/gn:delsvar[@id='8.4']) = 1 and
                        count(../gn:svar[@id='8']/gn:delsvar[@id='8.5']) = 1 and
                        count(../gn:svar[@id='8']/gn:delsvar[@id='8.6']) = 1">

        Om frågan "<value-of select="$svar1_1"/>" besvarats med något av valen IAV1 - IAV9
        OCH frågan "<value-of select="$svar8_1"/>" har besvarats med ett värde som är mindre än 0,1
        OCH frågan "Vänster öga utan korrektion (Delsvar)" (DFR 8.2) har besvarats med ett värde som är mindre än 0,1
        är "<value-of select="$svar8_4"/>", "<value-of select="$svar8_5"/>" och "<value-of select="$svar8_6"/>" obligatoriska att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R17-109.3-101.1-102.1-38.1-36.1-105.1-106.1-107.1-108.1">
    <iso:rule context="//gn:delsvar[@id=109.3]">
      <iso:assert test="count(../../gn:svar[@id='36']/gn:delsvar[@id='36.1']) = 1 and
                        count(../../gn:svar[@id='37']/gn:delsvar[@id='37.1']) = 1 and
                        count(../../gn:svar[@id='38']/gn:delsvar[@id='38.1']) = 1 and
                        count(../../gn:svar[@id='100']/gn:delsvar[@id='100.1']) = 1 and
                        count(../../gn:svar[@id='101']/gn:delsvar[@id='101.1']) = 1 and
                        count(../../gn:svar[@id='102']/gn:delsvar[@id='102.1']) = 1 and
                        count(../../gn:svar[@id='105']/gn:delsvar[@id='105.1']) = 1 and
                        count(../../gn:svar[@id='106']/gn:delsvar[@id='106.1']) = 1 and
                        count(../../gn:svar[@id='107']/gn:delsvar[@id='107.1']) = 1 and
                        count(../../gn:svar[@id='108']/gn:delsvar[@id='108.1']) = 1">

        Om "<value-of select="$svar109_3"/>" har något av värdena IAV1 - IAV8, måste även
        "<value-of select="$svar36_1"/>",
        "<value-of select="$svar37_1"/>",
        "<value-of select="$svar38_1"/>",
        "<value-of select="$svar100_1"/>",
        "<value-of select="$svar101_1"/>",
        "<value-of select="$svar102_1"/>",
        "<value-of select="$svar105_1"/>",
        "<value-of select="$svar106_1"/>",
        "<value-of select="$svar107_1"/>",
        "<value-of select="$svar108_1"/>" besvaras.
      </iso:assert>
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

</iso:schema>
