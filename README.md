# AplicacionADN
Esta aplicación se encuentra desplegada en aws amazon, la url es: http://springbootadn-env-1.eba-byxmhpde.us-east-2.elasticbeanstalk.com

Para ejecutar el servicio /stats ejecutar este endpoind por GET la aplicacion POSTMAN o desde un navegador: http://springbootadn-env-1.eba-byxmhpde.us-east-2.elasticbeanstalk.com/stats
este servicio muestra las estadisticas

Para ejecutar el servicio /mutant ejecutar este endpoind por POST desde  aplicacion POSTMAN http://springbootadn-env-1.eba-byxmhpde.us-east-2.elasticbeanstalk.com/mutant
y colocar en el body un objeto json de este tipo:

{
"cadenaAdn":["ATGCGA", "CAGTAC", "CTAAGT", "ACAAGA", "CCCCGA", "TCACGG"]
}

Para ejecutar el servicio /mutant ejecutar este endpoind por GET desde  aplicacion POSTMAN http://springbootadn-env-1.eba-byxmhpde.us-east-2.elasticbeanstalk.com/
Como resultado muestra las cadenas adn almacenadas en la base de datos.
