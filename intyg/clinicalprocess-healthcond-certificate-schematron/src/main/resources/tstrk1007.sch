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
      <iso:assert test="count(gn:svar[@id='1']) ge 1 and le 10">
        Ett intyg måste ha ett Intyget avser behörighet (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='2']) eq 1">
        Ett intyg måste ha ett Identitet styrkt genom (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='3']) eq 1">
        Ett intyg måste ha ett Tecken på synfältsdefekter vid undersökning enligt Donder (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='4']) eq 1">
        Ett intyg måste ha ett Begränsning av seende vid nedsatt belysning (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='5']) eq 1">
        Ett intyg måste ha ett Progressiv ögonsjukdom (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='6']) eq 1">
        Ett intyg måste ha ett Dubbelseende (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='7']) eq 1">
        Ett intyg måste ha ett Nystagmus (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='8']) eq 1">
        Ett intyg måste ha ett Synskärpa (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='10']) eq 1">
        Ett intyg måste ha ett Överraskande anfall av balansrubbningar eller yrsel (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='12']) eq 1">
        Ett intyg måste ha ett Sjukdom eller funktionsnedsättning som påverkar rörligheten och som medför att fordon inte kan köras på ett trafiksäkert sätt (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='14']) eq 1">
        Ett intyg måste ha ett Hjärt- eller kärlsjukdom som kan medföra en påtaglig risk för att hjärnans funktioner akut försämras eller som i övrigt innebär en trafiksäkerhetsrisk (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='15']) eq 1">
        Ett intyg måste ha ett Tecken på hjärnskada efter trauma, stroke eller annan sjukdom i centrala nervsystemet (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='16']) eq 1">
        Ett intyg måste ha ett Riskfaktorer för stroke (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='17']) eq 1">
        Ett intyg måste ha ett Har diabetes (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='20']) eq 1">
        Ett intyg måste ha ett Tecken på neurologisk sjukdom (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='21']) eq 1">
        Ett intyg måste ha ett Epelepsi, epeleptiskt anfall eller annan medvetandestörning (svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='22']) eq 1">
        Ett intyg måste ha ett Nedsatt njurfunktion som kan innebära en trafiksäkerhetsrisk (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='23']) eq 1">
        Ett intyg måste ha ett Tecken på sviktande kognitiv funktion (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='24']) eq 1">
        Ett intyg måste ha ett Tecken på sömn- eller vakenhetsstörning (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='25']) eq 1">
        Ett intyg måste ha ett Missbruk eller beroende av alkohol, narkotika eller läkemedel (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='26']) eq 1">
        Ett intyg måste ha ett Regelbundet läkarordinerat bruk av läkemedel som kan innebära trafiksäkerhetsrisk (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='27']) eq 1">
        Ett intyg måste ha ett Psykisk sjukdom eller störning (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='28']) eq 1">
        Ett intyg måste ha ett Psykisk utvecklingsstörning (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='29']) eq 1">
        Ett intyg måste ha ett ADHD, ADD, DAMP, Aspergers syndrom eller Tourettes syndrom (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='30']) eq 1">
        Ett intyg måste ha ett Vård på sjukhus eller kontakt med läkare (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='31']) eq 1">
        Ett intyg måste ha ett Stadigvarande medicinering (Svar)
      </iso:assert>

      <iso:assert test="count(gn:svar[@id='33']) ge 1 and le 10">
        Ett intyg måste ha ett Uppfyller krav för behörighet (Svar)
      </iso:assert>

      <iso:let name="svarsIdExpr" value="'^([123456789]|1[01234789]|2[012356789]|3[01234])$'"/>
      <iso:assert test="count(gn:svar[not(matches(@id, $svarsIdExpr))]) = 0">
        Oväntat svars-id. Svars-id:n måste matcha "<value-of select="$svarsIdExpr"/>".
      </iso:assert>

      <!-- Meddelandet kan innehålla ett valfritt antal tilläggsfrågor -->
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q1">
    <iso:rule context="//gn:svar[@id='1']">
      <iso:assert test="count(gn:delsvar[@id='1.1']) = 1">
        Ett Intyget avser behörighet (Svar) måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^1\.[1]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q1.1">
    <iso:rule context="//gn:delsvar[@id='1.1']">
      <iso:extends rule="cv"/>
      <iso:assert test="tp:cv/tp:codeSystem = '24c41b8d-258a-46bf-a08a-b90738b28770'">'codeSystem' måste vara '24c41b8d-258a-46bf-a08a-b90738b28770'.</iso:assert>
      <iso:assert test="matches(normalize-space(tp:cv/tp:code), '^(IAV[123456789]|1[0])$')">
        'Intyget avser behörighet' kan ha ett av värdena IAV1-IAV10
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q2">
    <iso:rule context="//gn:svar[@id='2']">
      <iso:assert test="count(gn:delsvar[@id='2.1']) = 1">
        Ett 'Identitet styrkt genom' måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^2\.[1]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q2.1">
    <iso:rule context="//gn:delsvar[@id='2.1']">
      <iso:extends rule="cv"/>
      <iso:assert test="tp:cv/tp:codeSystem = 'e7cc8f30-a353-4c42-b17a-a189b6876647'">'codeSystem' måste vara 'e7cc8f30-a353-4c42-b17a-a189b6876647'.</iso:assert>
      <iso:assert test="matches(normalize-space(tp:cv/tp:code), '^(IDK[123456])$')">
        'Identitet styrkt genom' kan ha ett av värdena IDK1-IDK6
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q3">
    <iso:rule context="//gn:svar[@id='3']">
      <iso:assert test="count(gn:delsvar[@id='3.1']) = 1">
        Ett 'Tecken på synfältsdefekter vid undersökning enligt Donder (svar)' måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^3\.[1]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q3.1">
    <iso:rule context="//gn:delsvar[@id='3.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q4">
    <iso:rule context="//gn:svar[@id='4']">
      <iso:assert test="count(gn:delsvar[@id='4.1']) = 1">
        Ett 'Begränsning av seende vid nedsatt belysning (svar)' måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^4\.[1]$'"/>
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
        Ett 'Progressiv ögonsjukdom (svar)' måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^5\.[1]$'"/>
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

  <iso:pattern id="q6">
    <iso:rule context="//gn:svar[@id='6']">
      <iso:assert test="count(gn:delsvar[@id='6.1']) = 1">
        Ett 'Dubbelseende (svar)' måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^6\.[1]$'"/>
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

  <iso:pattern id="q7">
    <iso:rule context="//gn:svar[@id='7']">
      <iso:assert test="count(gn:delsvar[@id='7.1']) = 1">
        Ett 'Nystagmus (svar)' måste ha ett delsvar
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^7\.[1]$'"/>
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

  <iso:pattern id="q8">
    <iso:rule context="//gn:svar[@id='8']">
      <iso:assert test="count(gn:delsvar[@id='8.1']) = 1">
        Ett 'Synskärpa (svar)' måste ha ett delsvar '8.1' (höger öga utan korrektion)
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='8.2']) = 1">
        Ett 'Synskärpa (svar)' måste ha ett delsvar '8.2' (vänster öga utan korrektion)
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='8.3']) = 1">
        Ett 'Synskärpa (svar)' måste ha ett delsvar '8.3' (binokulärt utan korrektion)
      </iso:assert>
      <iso:let name="delsvarsIdExpr" value="'^8\.[12345678]$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "<value-of select="$delsvarsIdExpr"/>".
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q8.1">
    <iso:rule context="//gn:delsvar[@id='8.1']">
      <iso:extends rule="decimal"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q8.2">
    <iso:rule context="//gn:delsvar[@id='8.2']">
      <iso:extends rule="decimal"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q8.3">
    <iso:rule context="//gn:delsvar[@id='8.3']">
      <iso:extends rule="decimal"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q8.4">
    <iso:rule context="//gn:delsvar[@id='8.4']">
      <iso:extends rule="decimal"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q8.5">
    <iso:rule context="//gn:delsvar[@id='8.5']">
      <iso:extends rule="decimal"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q8.6">
    <iso:rule context="//gn:delsvar[@id='8.6']">
      <iso:extends rule="decimal"/>
    </iso:rule>
  </iso:pattern>

  <!--<iso:pattern id="q8.4-R34">
    <iso:rule context="//gn:svar[@id='8']">
      <iso:assert test="matches(normalize-space(../gn:svar[@id='1']/gn:delsvar[@id='1.1']/tp:cv/tp:code), '^(IAV[123456789])$')">
        and abs(gn:delsvar[@id='8.1']) lt 0.8 and abs(//gn:delsvar[@id='8.2']) lt 0.8 and count(gn:delsvar[@id='8.4') = 0"
        Om DFR 1.1 besvarats med något av valen 'C1, C1E, C, CE, D1, D1E, D, DE eller Taxi'
        OCH frågan DFR 8.1 har besvarats med ett värde som är mindre än 0,8
        OCH frågan DFR 8.2 har besvarats med ett värde som är mindre än 0,8
        är (DFR 8.4) obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern> -->

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

  <iso:pattern id="decimal-pattern">
    <iso:rule id="decimal" abstract="true">
      <iso:assert test="count(*) = 0">Decimal-värde får inte vara inbäddat i något element.</iso:assert>
      <iso:assert test=". castable as xs:decimal">Decimalvärde</iso:assert>
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
