# AplicacionADN
Esta aplicación se encuentra desplegada en aws amazon, la url es: http://springbootadn-env-1.eba-byxmhpde.us-east-2.elasticbeanstalk.com

Para ejecutar el servicio /stats ejecutar este endpoind por GET la aplicacion POSTMAN o desde un navegador: http://springbootadn-env-1.eba-byxmhpde.us-east-2.elasticbeanstalk.com/stats

Para ejecutar el servicio /mutnat ejecutar este endpoind por POST desde  aplicacion POSTMAN http://springbootadn-env-1.eba-byxmhpde.us-east-2.elasticbeanstalk.com/mutant
y colocar en el body un objeto json de este tipo:

{
"cadenaAdn":["ATGCGA", "CAGTAC", "CTAAGT", "ACAAGA", "CCCCGA", "TCACGG"]
}

