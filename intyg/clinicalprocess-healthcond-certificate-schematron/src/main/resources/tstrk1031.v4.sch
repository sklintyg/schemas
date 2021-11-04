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

      <!-- Category 1 - Intyget avser -->
      <iso:assert test="count(gn:svar[@id='1']) ge 1 and count(gn:svar[@id='1']) le 16">
        Ett 'MU' måste ha mellan 1 och 16 'Intyget avser behörighet'
      </iso:assert>

      <!-- Category 2 - Identitet -->
      <iso:assert test="count(gn:svar[@id='2']) = 1">
        Ett 'MU' måste ha en 'Identitet styrkt genom'
      </iso:assert>

      <!-- Category 3 - Allmänt -->
      <iso:assert test="count(gn:svar[@id='205']) = 1">
        Ett 'MU' måste ha en 'Patienten följs avseende sin diabetessjukdom'
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
      <iso:assert test="count(gn:svar[@id='208']) le 1">
        Ett 'MU' får ha högst en 'Medicinering som medför risk för hypoglykemi'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='209']) le 1">
        Ett 'MU' får ha högst en 'Vilken behandling har patienten'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='210']) le 1">
        Ett 'MU' får ha högst en 'Ange när patienten började medicineringen'
      </iso:assert>

      <!-- Category 4 - Hypoglykemi -->
      <iso:assert test="count(gn:svar[@id='200']) le 1">
        Ett 'MU' får ha högst en 'Kontroll över sitt sjukdomstillstånd'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='201']) le 1">
        Ett 'MU' får ha högst en 'Förstår patienten riskerna med hypoglykemi'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='110']) le 1">
        Ett 'MU' får ha högst en 'Har förmåga att känna varningstecken'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='202']) le 1">
        Ett 'MU' får ha högst en 'Har patienten möjlighet att vidta adekvata åtgärder'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='106']) le 1">
        Ett 'MU' får ha högst en 'Har patienten möjlighet att vidta adekvata åtgärder'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='107']) le 1">
        Ett 'MU' får ha högst en 'Förekomst av återkommande allvarlig hypoglykemi i vaket tillstånd under den senaste tolvmånadersperioden'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='203']) le 1">
        Ett 'MU' får ha högst en 'Har patienten haft allvarlig hypoglykemi under de senaste tolv månaderna'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='204']) le 1">
        Ett 'MU' får ha högst en 'Genomför patienten regelbundna blodsockerkontroller minst två gånger om dagen och i samband med körning'
      </iso:assert>

      <!-- Category 6 - Övrigt -->
      <iso:assert test="count(gn:svar[@id='206']) = 1">
        Ett 'MU' måste ha en 'Komplikationer till följd av sjukdomen'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='34']) le 1">
        Ett 'MU' får ha högst ett 'Bör undersökas av specialistläkare'
      </iso:assert>

      <!-- Category 7 - Bedömning -->
      <iso:assert test="count(gn:svar[@id='33']) ge 1 and count(gn:svar[@id='1']) le 16">
        Ett 'MU' måste ha mellan 1 och 16 'Uppfyller krav för behörighet'
      </iso:assert>
      <iso:assert test="count(gn:svar[@id='32']) le 1">
        Ett 'MU' får ha högst ett 'Övriga kommentarer'
      </iso:assert>

      <iso:let name="svarsIdExpr" value="'^1$|2$|205$|35$|18$|207$|208$|209$|210$|200$|201$|110$|202$|106$|107$|203$|204$|206$|34$|33$|32$'"/>
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
      <iso:assert test="tp:cv/tp:codeSystem = 'e889fa20-1dee-4f79-8b37-03853e75a9f8'">'codeSystem' måste vara
        'e889fa20-1dee-4f79-8b37-03853e75a9f8'.
      </iso:assert>
      <iso:assert test="matches(normalize-space(tp:cv/tp:code), '^VAR([1-9]$|1[2-8]$)')">
        'Intyget avser behörighet' kan ha ett av värdena VAR1 - VAR9 eller VAR12 - VAR18.
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
      <iso:assert test="count(gn:delsvar[@id=18.1]) = 1">
        'Typ av diabetes' måste ha ett delsvar
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
      <iso:assert test="matches(normalize-space(tp:cv/tp:code), '^E10$|^E11$|^E109$|^E13$')">
        'Typ av diabetes' kan ha ett av värdena E10, E11, E109 eller E13.
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

  <iso:pattern id="q209">
    <iso:rule context="//gn:svar[@id='209']">
      <iso:let name="delsvarsIdExpr" value="'^209\.1$|^209\.2$|^209\.3$|^209\.4$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='209.1']) le 1">
        'Insulinbehandling' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='209.2']) le 1">
        'Tablettbehandling' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='209.3']) le 1">
        'Annan behandling' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='209.4']) le 1">
        'Annan behandling anges' får ha högst ett delsvar
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='209.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='209.2']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='209.3']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='209.4']">
      <iso:extends rule="non-empty-string"/>
      <iso:assert test="string-length(normalize-space(text())) le 53">
        'Annan behandling anges' får inte överskrida 53 tecken.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q210">
    <iso:rule context="//gn:svar[@id='210']">
      <iso:let name="delsvarsIdExpr" value="'^210\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='210.1']) = 1">
        'Ange när patienten började medicineringen' måste ha ett delsvar
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='210.1']">
      <iso:extends rule="partial-date"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q200">
    <iso:rule context="//gn:svar[@id='200']">
      <iso:let name="delsvarsIdExpr" value="'^200\.1$|^200\.2$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='200.1']) = 1">
        'Kontroll över sitt sjukdomstillstånd' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='200.2']) le 1">
        'Varför har patienten inte kontroll' får ha högst ett delsvar
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='200.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='200.2']">
      <iso:extends rule="non-empty-string"/>
      <iso:assert test="string-length(normalize-space(text())) le 53">
        'Varför har patienten inte kontroll' får inte överskrida 53 tecken.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q201">
    <iso:rule context="//gn:svar[@id='201']">
      <iso:let name="delsvarsIdExpr" value="'^201\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='201.1']) = 1">
        'Förstår patienten riskerna med hypoglykemi' måste ha ett delsvar
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='201.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q110">
    <iso:rule context="//gn:svar[@id='110']">
      <iso:let name="delsvarsIdExpr" value="'^110\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='110.1']) = 1">
        'Har förmåga att känna varningstecken' måste ha ett delsvar
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='110.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q202">
    <iso:rule context="//gn:svar[@id='202']">
      <iso:let name="delsvarsIdExpr" value="'^202\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='202.1']) = 1">
        'Har patienten möjlighet att vidta adekvata åtgärder' måste ha ett delsvar
      </iso:assert>

    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='202.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q106">
    <iso:rule context="//gn:svar[@id='106']">
      <iso:let name="delsvarsIdExpr" value="'^106\.1$|106\.2$|106\.3$|106\.5$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='106.1']) = 1">
        'Förekomst av återkommande allvarlig hypoglykemi under det senaste året' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='106.2']) le 1">
        'Senaste tidpunkt för återkommande allvarlig hypoglykemi' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='106.3']) le 1">
        'Kontrolleras sjukdomen regelbundet' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='106.5']) le 1">
        'Utgör tillståndet någon trafiksäkerhetsrisk' får ha högst ett delsvar
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='106.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='106.2']">
      <iso:extends rule="partial-date"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='106.3']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='106.5']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q107">
    <iso:rule context="//gn:svar[@id='107']">
      <iso:let name="delsvarsIdExpr" value="'^107\.1$|107\.3$|107\.5$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='107.1']) = 1">
        'Förekomst av återkommande allvarlig hypoglykemi i vaket tillstånd under den senaste tolvmånadersperioden' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='107.3']) le 1">
        'Har den senaste allvarliga hypoglykemin inträffat under de senaste tre månaderna' får ha högst ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='107.5']) le 1">
        'Senaste tidpunkt för allvarliga hypoglykemin inträffad under de senaste tre månaderna ' får ha högst ett delsvar
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='107.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='107.3']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='107.5']">
      <iso:extends rule="partial-date"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q203">
    <iso:rule context="//gn:svar[@id='203']">
      <iso:let name="delsvarsIdExpr" value="'^203\.1$|203\.2$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='203.1']) = 1">
        'Har patienten haft allvarlig hypoglykemi under de senaste tolv månaderna' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='203.2']) le 1">
        'Senast inträffade allvarlig hypoglykemi (under de senaste tolv månaderna)' får ha högst ett delsvar
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='203.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='203.2']">
      <iso:extends rule="partial-date"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q204">
    <iso:rule context="//gn:svar[@id='204']">
      <iso:let name="delsvarsIdExpr" value="'^204\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='204.1']) = 1">
        'Genomför patienten regelbundna blodsockerkontroller minst två gånger om dagen och i samband med körning' måste ha ett delsvar
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='204.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q206">
    <iso:rule context="//gn:svar[@id='206']">
      <iso:let name="delsvarsIdExpr" value="'^206\.1$|^206\.2$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='206.1']) = 1">
        'Komplikationer till följd av sjukdomen' måste ha ett delsvar
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='206.2']) le 1">
        'Komplikationer anges' får ha högst ett delsvar
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='206.1']">
      <iso:extends rule="boolean"/>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='206.2']">
      <iso:extends rule="non-empty-string"/>
      <iso:assert test="string-length(normalize-space(text())) le 189">
        'Komplikationer anges' får inte överskrida 189 tecken.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="q34">
    <iso:rule context="//gn:svar[@id='34']">
      <iso:let name="delsvarsIdExpr" value="'^34\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='34.1']) = 1">
        'Bör undersökas av specialistläkare' måste ha ett delsvar
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='34.1']">
      <iso:extends rule="non-empty-string"/>
      <iso:assert test="string-length(normalize-space(text())) le 71">
        'Bör undersökas av specialistläkare' Får inte överskrida 71 tecken.
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

  <iso:pattern id="q32">
    <iso:rule context="//gn:svar[@id='32']">
      <iso:let name="delsvarsIdExpr" value="'^32\.1$'"/>
      <iso:assert test="count(gn:delsvar[not(matches(@id, $delsvarsIdExpr))]) = 0">
        Oväntat delsvars-id i delsvar till svar "<value-of select="@id"/>". Delsvars-id:n måste matcha "
        <value-of select="$delsvarsIdExpr"/>
        ".
      </iso:assert>
      <iso:assert test="count(gn:delsvar[@id='32.1']) = 1">
        'Övriga kommentarer' måste ha ett delsvar
      </iso:assert>
    </iso:rule>

    <iso:rule context="//gn:delsvar[@id='32.1']">
      <iso:extends rule="non-empty-string"/>
      <iso:assert test="string-length(normalize-space(text())) le 189">
        'Övriga kommentarer' får inte överskrida 189 tecken.
      </iso:assert>
    </iso:rule>
  </iso:pattern>


  <!--#####
# Rules #
######-->

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
    <iso:rule context="//gn:delsvar[@id='18.1' and matches(normalize-space(tp:cv/tp:code), '^E13$')]">
      <iso:assert test="count(../gn:delsvar[@id=18.2]) = 1">
        Om 'Typ av diabetes' (DFR 18.1) besvaras med 'Annan' ska 'Beskrivning annan diabetes' (DFR 18.2) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R4">
    <iso:rule context="//gn:svar[@id='209']">
      <iso:assert test="count(gn:delsvar[@id=209.1 and matches(normalize-space(.), 'true|1')]) = 1 or
                        count(gn:delsvar[@id=209.2 and matches(normalize-space(.), 'true|1')]) = 1 or
                        count(gn:delsvar[@id=209.3 and matches(normalize-space(.), 'true|1')]) = 1">
        Minst en av frågorna 'Insulin' (DFR 209.1), 'Tabletter' (DFR 209.2), 'Annan' (DFR 209.3) måste besvaras.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R8">
    <iso:rule context="//gn:delsvar[@id='106.1' and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(../gn:delsvar[@id='106.2']) = 1">
        Om 'Förekomst av återkommande allvarlig hypoglykemi under det senaste året' (DFR 106.1) besvaras med 'Ja' ska 'Senaste tidpunkt för återkommande allvarlig hypoglykemi' (DFR 106.2) vara obligatorisk att besvara.
      </iso:assert>
      <iso:assert test="count(../gn:delsvar[@id='106.3']) = 1">
        Om 'Förekomst av återkommande allvarlig hypoglykemi under det senaste året' (DFR 106.1) besvaras med 'Ja' ska 'Kontrolleras sjukdomen regelbundet' (DFR 106.3) vara obligatorisk att besvara.
      </iso:assert>
      <iso:assert test="count(../gn:delsvar[@id='106.5']) = 1">
        Om 'Förekomst av återkommande allvarlig hypoglykemi under det senaste året' (DFR 106.1) besvaras med 'Ja' ska 'Utgör tillståndet någon trafiksäkerhetsrisk' (DFR 106.5) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R9">
    <iso:rule context="//gn:delsvar[@id='107.1' and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(../gn:delsvar[@id='107.3']) = 1">
        Om 'Förekomst av  återkommande allvarlig hypoglykemi i vaket tillstånd under den senaste tolvmånadersperioden' (DFR 107.1) besvaras
        med 'Ja' ska 'Har den senaste allvarliga hypoglykemin inträffat under de senaste tre månaderna' (DFR 107.3) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R18">
    <iso:rule context="//gn:delsvar[@id=209.3 and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(../gn:delsvar[@id=209.4]) = 1">
        Om frågan "Behandling annan (Delsvar)" (DFR 209.3) besvaras ska frågan  "Ange vilken (Delsvar)" (DFR 209.4) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R19-R20-R21-R22">
    <iso:let name="currDate" value="xs:date(current-date())"/>
    <iso:let name="personId" value="//gn:person-id/tp:extension" />
    <!-- Handle samordningsnummer -->
    <iso:let name="birthDay" value="if (substring($personId,7,2) lt '60') then substring($personId,7,2) else xs:string(xs:integer(substring($personId,7,2)) - 60)" />
    <iso:let name="birthDate" value="xs:date(string-join((substring($personId,1,4),substring($personId,5,2),$birthDay), '-'))"/>

    <!-- R19 -->
    <iso:rule context="//gn:delsvar[@id='210.1']">
      <iso:let name="dateValue" value="xs:date(tp:partialDate/tp:value)"/>
      <iso:assert test="$dateValue le $currDate">
        Datum som anges i delfråga 'DFR 210.1' får inte vara senare än dagens datum.
      </iso:assert>
      <iso:assert test="$birthDate le $dateValue">
        Datum i delsvar delfråga 'DFR 210.1' måste vara ett datum som inte är tidigare än det datum patienten är född.
      </iso:assert>
    </iso:rule>

    <!-- R20 -->
    <iso:rule context="//gn:delsvar[@id='106.2']">
      <iso:let name="dateValue" value="xs:date(tp:partialDate/tp:value)"/>
      <iso:assert test="$dateValue le $currDate">
        Datum som anges i delfråga 'DFR 106.2' får inte vara senare än dagens datum.
      </iso:assert>
      <iso:assert test="$birthDate le $dateValue">
        Datum i delsvar delfråga 'DFR 106.2' måste vara ett datum som inte är tidigare än det datum patienten är född.
      </iso:assert>
    </iso:rule>

    <!-- R21 -->
    <iso:rule context="//gn:delsvar[@id='107.5']">
      <iso:let name="dateValue" value="xs:date(tp:partialDate/tp:value)"/>
      <iso:assert test="$dateValue le $currDate">
        Datum som anges i delfråga 'DFR 107.5' får inte vara senare än dagens datum.
      </iso:assert>
      <iso:assert test="$birthDate le $dateValue">
        Datum i delsvar delfråga 'DFR 107.5' måste vara ett datum som inte är tidigare än det datum patienten är född.
      </iso:assert>
    </iso:rule>

    <!-- R22 -->
    <iso:rule context="//gn:delsvar[@id='203.2']">
      <iso:let name="dateValue" value="xs:date(tp:partialDate/tp:value)"/>
      <iso:assert test="$dateValue le $currDate">
        Datum som anges i delfråga 'DFR 203.2' får inte vara senare än dagens datum.
      </iso:assert>
      <iso:assert test="$birthDate le $dateValue">
        Datum i delsvar delfråga 'DFR 203.2' måste vara ett datum som inte är tidigare än det datum patienten är född.
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

  <iso:pattern id="R27">
    <iso:rule context="//gn:delsvar[@id='200.1' and matches(normalize-space(.), 'false|0')]">
      <iso:assert test="count(../gn:delsvar[@id='200.2']) = 1">
        Om 'Kontroll över sitt sjukdomstillstånd' (DFR 201.1) besvaras med 'Nej' ska 'Varför inte Kontroll över sitt sjukdomstillstånd' (DFR 200.2) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='200.1' and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(../gn:delsvar[@id='200.2']) = 0">
        Om 'Kontroll över sitt sjukdomstillstånd' (DFR 201.1) besvaras med 'Ja' ska 'Varför inte Kontroll över sitt sjukdomstillstånd' (DFR 200.2) inte vara besvarad.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R28">
    <iso:rule context="//gn:delsvar[@id='1.1' and matches(normalize-space(tp:cv/tp:code), '^VAR[1-9]$')]">
      <iso:assert test="count(../../gn:svar[@id='203']/gn:delsvar[@id='203.1']) = 1">
        Om 'Intyget avser behörighet' har något av värdena VAR1 - VAR9, måste även 'Har patienten haft allvarlig hypoglykemi under de senaste tolv månaderna' besvaras.
      </iso:assert>
      <iso:assert test="count(../../gn:svar[@id='204']/gn:delsvar[@id='204.1']) = 1">
        Om 'Intyget avser behörighet' har något av värdena VAR1 - VAR9, måste även 'Genomför patienten regelbundna blodsockerkontroller minst två gånger om dagen och i samband med körning' besvaras.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R29">
    <iso:rule context="//gn:delsvar[@id='206.1' and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(../gn:delsvar[@id='206.2']) = 1">
        Om 'Komplikationer till följd av sjukdomen' (DFR 206.1) besvaras med 'Ja' ska 'Komplikationer anges' (DFR 206.2) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R30">
    <iso:rule context="//gn:delsvar[@id='208.1' and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(../../gn:svar[@id='200']/gn:delsvar[@id='200.1']) = 1">
        Om 'Medicinering medför risk för hypoglykemi' (DFR 208.1) besvaras med 'Ja' är 'Kontroll över sitt sjukdomstillstånd' (DFR 200.1) obligatorisk att besvara.
      </iso:assert>
      <iso:assert test="count(../../gn:svar[@id='201']/gn:delsvar[@id='201.1']) = 1">
        Om 'Medicinering medför risk för hypoglykemi' (DFR 208.1) besvaras med 'Ja' är 'Förstår patienten riskerna med hypoglykemi' (DFR 201.1) obligatorisk att besvara.
      </iso:assert>
      <iso:assert test="count(../../gn:svar[@id='110']/gn:delsvar[@id='110.1']) = 1">
        Om 'Medicinering medför risk för hypoglykemi' (DFR 208.1) besvaras med 'Ja' är 'Har förmåga att känna varningstecken' (DFR 110.1) obligatorisk att besvara.
      </iso:assert>
      <iso:assert test="count(../../gn:svar[@id='202']/gn:delsvar[@id='202.1']) = 1">
        Om 'Medicinering medför risk för hypoglykemi' (DFR 208.1) besvaras med 'Ja' är 'Har patienten möjlighet att vidta adekvata åtgärder' (DFR 202.1) obligatorisk att besvara.
      </iso:assert>
      <iso:assert test="count(../../gn:svar[@id='106']/gn:delsvar[@id='106.1']) = 1">
        Om 'Medicinering medför risk för hypoglykemi' (DFR 208.1) besvaras med 'Ja' är 'Förekomst av återkommande allvarlig hypoglykemi under det senaste året' (DFR 106.1) obligatorisk att besvara.
      </iso:assert>
      <iso:assert test="count(../../gn:svar[@id='107']/gn:delsvar[@id='107.1']) = 1">
        Om 'Medicinering medför risk för hypoglykemi' (DFR 208.1) besvaras med 'Ja' är 'Förekomst av återkommande allvarlig hypoglykemi i vaket tillstånd under den senaste tolvmånadersperioden' (DFR 107.1) obligatorisk att besvara.
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

  <iso:pattern id="R33">
    <iso:rule context="//gn:delsvar[@id='107.3' and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(../gn:delsvar[@id='107.5']) = 1">
        Om 'Har den senaste allvarliga hypoglykemin inträffat under de senaste tre månaderna' (DFR 107.3) besvaras
        med 'Ja' ska 'Senaste tidpunkt för allvarliga hypoglykemin inträffad under de senaste tre månaderna' (DFR 107.5) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R34">
    <iso:rule context="//gn:delsvar[@id='203.1' and matches(normalize-space(.), 'true|1')]">
      <iso:assert test="count(../gn:delsvar[@id='203.2']) = 1">
        Om 'Har patienten haft allvarlig hypoglykemi under de senaste tolv månaderna' (DFR 203.1) besvaras
        med 'Ja' ska 'Senast inträffade allvarlig hypoglykemi (under de senaste tolv månaderna)' (DFR 203.2) vara obligatorisk att besvara.
      </iso:assert>
    </iso:rule>
  </iso:pattern>

  <iso:pattern id="R35">
    <iso:rule context="//gn:delsvar[@id='33.1' and matches(normalize-space(tp:cv/tp:code), '^VAR9$')]">
      <iso:assert test="../../gn:svar[@id='1']/gn:delsvar[@id='1.1' and matches(normalize-space(tp:cv/tp:code),'^VAR9$')]">
        Vald behörighet överensstämmer inte med vilken behörighet intyget avser.
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='33.1' and matches(normalize-space(tp:cv/tp:code), '^VAR8$')]">
      <iso:assert test="../../gn:svar[@id='1']/gn:delsvar[@id='1.1' and matches(normalize-space(tp:cv/tp:code),'^VAR8$')]">
        Vald behörighet överensstämmer inte med vilken behörighet intyget avser.
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='33.1' and matches(normalize-space(tp:cv/tp:code), '^VAR7$')]">
      <iso:assert test="../../gn:svar[@id='1']/gn:delsvar[@id='1.1' and matches(normalize-space(tp:cv/tp:code),'^VAR7$')]">
        Vald behörighet överensstämmer inte med vilken behörighet intyget avser.
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='33.1' and matches(normalize-space(tp:cv/tp:code), '^VAR6$')]">
      <iso:assert test="../../gn:svar[@id='1']/gn:delsvar[@id='1.1' and matches(normalize-space(tp:cv/tp:code),'^VAR6$')]">
        Vald behörighet överensstämmer inte med vilken behörighet intyget avser.
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='33.1' and matches(normalize-space(tp:cv/tp:code), '^VAR5$')]">
      <iso:assert test="../../gn:svar[@id='1']/gn:delsvar[@id='1.1' and matches(normalize-space(tp:cv/tp:code),'^VAR5$')]">
        Vald behörighet överensstämmer inte med vilken behörighet intyget avser.
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='33.1' and matches(normalize-space(tp:cv/tp:code), '^VAR4$')]">
      <iso:assert test="../../gn:svar[@id='1']/gn:delsvar[@id='1.1' and matches(normalize-space(tp:cv/tp:code),'^VAR4$')]">
        Vald behörighet överensstämmer inte med vilken behörighet intyget avser.
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='33.1' and matches(normalize-space(tp:cv/tp:code), '^VAR3$')]">
      <iso:assert test="../../gn:svar[@id='1']/gn:delsvar[@id='1.1' and matches(normalize-space(tp:cv/tp:code),'^VAR3$')]">
        Vald behörighet överensstämmer inte med vilken behörighet intyget avser.
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='33.1' and matches(normalize-space(tp:cv/tp:code), '^VAR2$')]">
      <iso:assert test="../../gn:svar[@id='1']/gn:delsvar[@id='1.1' and matches(normalize-space(tp:cv/tp:code),'^VAR2$')]">
        Vald behörighet överensstämmer inte med vilken behörighet intyget avser.
      </iso:assert>
    </iso:rule>
    <iso:rule context="//gn:delsvar[@id='33.1' and matches(normalize-space(tp:cv/tp:code), '^VAR1$')]">
      <iso:assert test="../../gn:svar[@id='1']/gn:delsvar[@id='1.1' and matches(normalize-space(tp:cv/tp:code),'^VAR1$')]">
        Vald behörighet överensstämmer inte med vilken behörighet intyget avser.
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

</iso:schema>
