
cd sshr.domainmodel
call ant
cd ..


rem cd sshr.entitymodel.testing
rem call ant
rem cd ..


cd sshr.datamodel
call ant
cd ..


cd sshr.eventmodel
call ant
cd ..


rem cd sshr.eventmodel.testing
rem call ant
rem cd ..


cd sshr.servicemodel
call ant
cd ..


cd sshr.asistencia
call ant
cd ..


cd sshr
call ant
cd ..


cd sshr.gae-web-interface
ant compile
cd ..

