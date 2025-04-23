# Facturacion

Trabajo hecho por Juan Angel Gomez, Padrón 87943
las clases y test fueron implementadas en java, se implemento en eclipse de java
Detalle de implementacion:
* se penso en un inicio añadir el codigo de estado a cada item, pero se opto por ligarlo a la clase factura y meter un unico impuesto para toda la factura.
* por omision se mete un impuesto como si estuviera en  "UT" con un impuesto de 6,85%.
* las facturas se crean con nuro correlativo, cuando se crea en memoria la factura recuerda cual es el nro de factura anterior.
* para guardar los items de la factura, se eligio un arrayList.
* se programo una funcion en factura que calcula el descuento aplicable segun el subtoral de los items.
* tambien se hizo una funcion para aplicar el impuesto.
* a la hora de crear los elementos se valida que los parametros sean correctos, sino caso contrario se revolean excepciones de argumento invalido

se escribieron los test y el mail, se realizan validaciones antes de crear las clases para evitar los throws en el principal.

para correrlo simplemente ejecutar el main.java
para correr las pruebas ejecutar los test con junit5
