# comlic-monger-server
Server for Comic Monger

## Working with mysql
docker exec -it mysql8 mysql -p

==>
CREATE USER 'sa'@'%' IDENTIFIED BY 'root';
GRANT ALL PRIVILEGES ON *.* TO 'sa'@'%';
FLUSH PRIVILEGES;
