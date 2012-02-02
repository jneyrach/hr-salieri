
cd dist-lib
erase * /q
cd ..


rem cd lib


cd sshr
call ant clean
cd ..


cd sshr.asistencia
call ant clean
cd ..


cd sshr.datamodel
call ant clean
cd ..


cd sshr.domainmodel
call ant clean
cd ..


cd sshr.entitymodel.testing
call ant clean
cd ..


cd sshr.eventmodel
call ant clean
cd ..


cd sshr.eventmodel.testing
call ant clean
cd ..


cd sshr.servicemodel
call ant clean
cd ..


cd sshr.gae-web-interface
erase war\WEB-INF\classes\* /s /q
erase war\WEB-INF\lib\* /s /q
erase war\WEB-INF\appengine-generated\* /s /q
cd ..

