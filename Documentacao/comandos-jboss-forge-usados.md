### Comando inicial
project-new --named grid --top-level-package org.iel.oitavo_periodo.projeto_integrador --type war --final-name Grid

### Configurando o hibernate 
jpa-setup --provider Hibernate --container WILDFLY --jpa-version 2.1


### Configurando as entidades e seus campos

* Estados Brasileiros Enum

```sh
java-new-enum --named  EstadosBrasileirosEnum --target-package org.iel.oitavo_periodo.projeto_integrador.enums
```

* Semestre Enum

```sh
java-new-enum --named  SemestreEnum --target-package org.iel.oitavo_periodo.projeto_integrador.enums
java-new-enum-const primeiro
java-new-enum-const segundo
```

* Dias Enum

```sh
java-new-enum --named  DiasEnum --target-package org.iel.oitavo_periodo.projeto_integrador.enums
java-new-enum-const segundaFeira
java-new-enum-const tercaFeira
java-new-enum-const quartaFeira
java-new-enum-const quintaFeira
java-new-enum-const sextaFeira
java-new-enum-const sabado
java-new-enum-const domingo
```

```sh
java-new-enum --named  CargoEnum --target-package org.iel.oitavo_periodo.projeto_integrador.enums
```

```sh
java-new-enum --named  FormacaoEnum --target-package org.iel.oitavo_periodo.projeto_integrador.enums
```

```sh
java-new-enum --named  GrauMotivoEnum --target-package org.iel.oitavo_periodo.projeto_integrador.enums
```

```sh
java-new-enum --named  TitulacaoEnum --target-package org.iel.oitavo_periodo.projeto_integrador.enums
```

```sh
java-new-enum --named  RegimeEnum --target-package org.iel.oitavo_periodo.projeto_integrador.enums
```


* Endereco

```sh
jpa-new-entity --named Endereco --target-package org.iel.oitavo_periodo.projeto_integrador.entities --id-strategy AUTO --table-name tab-endereco
jpa-new-field --named nomeRua --type String --column-name nome_rua --length 50 --not-nullable
jpa-new-field --named complemento --type String --column-name complemento --length 50 --not-nullable
jpa-new-field --named bairro --type String --column-name bairro --length 50 --not-nullable
jpa-new-field --named municipio --type String --column-name municipio --length 50 --not-nullable
jpa-new-field --named cep --type String --column-name cep --length 8 --not-nullable
```

* Usuario

```sh
jpa-new-entity --named Usuario --target-package org.iel.oitavo_periodo.projeto_integrador.entities --id-strategy AUTO --table-name tab-usuario
jpa-new-field --named nomeCompleto --type String --column-name nome_completo --length 200 --not-nullable
jpa-new-field --named login --type String --column-name login --length 120 --not-nullable
jpa-new-field --named senha --type String --column-name senha --length 120 --not-nullable
```

* Professor

```sh
jpa-new-entity --named Professor --target-package org.iel.oitavo_periodo.projeto_integrador.entities --id-strategy AUTO --table-name tab-professor
jpa-new-field --named nomeCompleto --type String --column-name nome_completo --length 200 --not-nullable
jpa-new-field --named regime --type org.iel.oitavo_periodo.projeto_integrador.enums.RegimeEnum --enum-type STRING --not-nullable
jpa-new-field --named cargo --type org.iel.oitavo_periodo.projeto_integrador.enums.CargoEnum --enum-type STRING --not-nullable
jpa-new-field --named dataAdmissao --type java.util.Date --temporal-type DATE --column-name data_admissao
jpa-new-field --named formacao --type org.iel.oitavo_periodo.projeto_integrador.enums.FormacaoEnum --enum-type STRING --not-nullable
jpa-new-field --named titulacao --type org.iel.oitavo_periodo.projeto_integrador.enums.TitulacaoEnum --enum-type STRING --not-nullable
```

* DiaNaoDisponivel

```sh
jpa-new-entity --named DiaNaoDisponivel --target-package org.iel.oitavo_periodo.projeto_integrador.entities --id-strategy AUTO --table-name tab-dia-nao-disponivel
jpa-new-field --named dia --type org.iel.oitavo_periodo.projeto_integrador.enums.DiaEnum --enum-type STRING --not-nullable
jpa-new-field --named motivo --type String --column-name motivo --length 150 --not-nullable
jpa-new-field --named grauMotivo --type org.iel.oitavo_periodo.projeto_integrador.enums.GrauMotivoEnum --enum-type STRING --not-nullable

```

* DisponibilidadeProfessor

```sh
jpa-new-entity --named DisponibilidadeProfessor --target-package org.iel.oitavo_periodo.projeto_integrador.entities --id-strategy AUTO --table-name tab-disponibilidade-professor
jpa-new-field --named professor --type org.iel.oitavo_periodo.projeto_integrador.entities.Professor --required  --relationship-type One-to-Many --column-name id_professor
jpa-new-field --named ano --type String --column-name ano --length 4 --not-nullable --not-updatable
jpa-new-field --named semestre --type org.iel.oitavo_periodo.projeto_integrador.enums.SemestreEnum --enum-type STRING --not-nullable

```

* Disciplina

```sh
jpa-new-entity --named Disciplina --target-package org.iel.oitavo_periodo.projeto_integrador.entities --id-strategy AUTO --table-name tab-disciplina
jpa-new-field --named nome --type String --column-name nome --length 200 --not-nullable
jpa-new-field --named descricao --type String --column-name descricao --length 200 --not-nullable
jpa-new-field --named cargaHoraria --type String --column-name cargaHoraria --length 6 --not-nullable

```

* Curso

```sh
jpa-new-entity --named Curso --target-package org.iel.oitavo_periodo.projeto_integrador.entities --id-strategy AUTO --table-name tab-curso
jpa-new-field --named nome --type String --column-name nome --length 200 --not-nullable
jpa-new-field --named descricao --type String --column-name descricao --length 200 --not-nullable
jpa-new-field --named tempoDuracao --type String --column-name tempo_duracao --length 6 --not-nullable

```

* Turma

```sh
jpa-new-entity --named Turma --target-package org.iel.oitavo_periodo.projeto_integrador.entities --id-strategy AUTO --table-name tab-turma
jpa-new-field --named ano --type String --column-name ano --length 4 --not-nullable --not-updatable
jpa-new-field --named semestre --type org.iel.oitavo_periodo.projeto_integrador.enums.SemestreEnum --enum-type STRING --not-nullable
jpa-new-field --named curso --type org.iel.oitavo_periodo.projeto_integrador.entities.Curso --required  --relationship-type One-to-Many --column-name id_curso

```

* Instituicao

```sh
jpa-new-entity --named Instituicao --target-package org.iel.oitavo_periodo.projeto_integrador.entities --id-strategy AUTO --table-name tab-instituicao
jpa-new-field --named cnpj --type String --column-name cnpj --length 15 --not-nullable
jpa-new-field --named endereco --type org.iel.oitavo_periodo.projeto_integrador.entities.Endereco --required  --relationship-type One-to-Many --column-name id_endereco
jpa-new-field --named razaoSocial --type String --column-name razao_social --length 200 --not-nullable
jpa-new-field --named nomeFantasia --type String --column-name nome_fantasia --length 200 --not-nullable
```

### Daos
jpa-generate-daos-from-entities --persistence-unit grid-persistence-unit --targets org.iel.oitavo_periodo.projeto_integrador.entities.Curso  org.iel.oitavo_periodo.projeto_integrador.entities.DiaNaoDisponivel org.iel.oitavo_periodo.projeto_integrador.entities.Disciplina org.iel.oitavo_periodo.projeto_integrador.entities.DisponibilidadeProfessor org.iel.oitavo_periodo.projeto_integrador.entities.Endereco org.iel.oitavo_periodo.projeto_integrador.entities.Instituicao org.iel.oitavo_periodo.projeto_integrador.entities.Professor org.iel.oitavo_periodo.projeto_integrador.entities.Turma org.iel.oitavo_periodo.projeto_integrador.entities.Usuario


### Rest
rest-setup --applicationPath rest --targetPackage org.iel.oitavo_periodo.projeto_integrador.rest --config APP_CLASS
rest-generate-endpoints-from-entities --content-type application/xml --persistence-unit grid-persistence-unit --targets org.iel.oitavo_periodo.projeto_integrador.entities.Curso  org.iel.oitavo_periodo.projeto_integrador.entities.DiaNaoDisponivel org.iel.oitavo_periodo.projeto_integrador.entities.Disciplina org.iel.oitavo_periodo.projeto_integrador.entities.DisponibilidadeProfessor org.iel.oitavo_periodo.projeto_integrador.entities.Endereco org.iel.oitavo_periodo.projeto_integrador.entities.Instituicao org.iel.oitavo_periodo.projeto_integrador.entities.Professor org.iel.oitavo_periodo.projeto_integrador.entities.Turma org.iel.oitavo_periodo.projeto_integrador.entities.Usuario

