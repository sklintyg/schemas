# Intyg Schemas
Intyg Schemas tillhandahåller scheman till de övriga intygsprojekten under [SKL Intyg](http://github.com/sklintyg).

## Kom igång
Här hittar du grundläggande instruktioner för hur man kommer igång med projektet. Mer detaljerade instruktioner för att sätta upp sin utvecklingsmiljö och liknande hittar du på projektets [Wiki för utveckling](https://github.com/sklintyg/common/wiki).

### Bygg projektet
Intyg Schemas byggs med hjälp av Maven enligt följande:
```
$ git clone https://github.com/sklintyg/schemas.git

$ cd schemas
$ ./gradlew clean build
```

För att publisera till lokalt Maven-repo används
```
$ ./gradlew install
```

### Stöd för namespace prefixes
Vi använder en extension till JAXB för att kunna generera package-info.java för XMLDSig utan namespace-prefix. Se:

https://github.com/Siggen/jaxb2-namespace-prefix

## Licens
Copyright (C) 2014 Inera AB (http://www.inera.se)

Intyg Schemas is free software: you can redistribute it and/or modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Intyg Schemas is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU LESSER GENERAL PUBLIC LICENSE for more details.

Se även [LICENSE.md](https://github.com/sklintyg/common/blob/master/LICENSE.md). 
