#!/bin/bash 

# このスクリプト(init.sh)のディレクトリの絶対パスを取得
DIR=$(cd $(dirname $0); pwd)

#mysqlへの接続用情報
MYSQL_ID='root'
MYSQL_PWD='root'
MYSQL_HOST='localhost'
MYSQL_SCHEMA='testDB'

#実行するSQL
CREATE_BOND=${DIR}/createTable/create_bond.sql

#import用CSV
INSERT_BOND=${DIR}/data/BOND.csv

#mysql接続コマンド
CMD_MYSQL="mysql  -u${MYSQL_ID} -p${MYSQL_PWD} --database=${MYSQL_SCHEMA}"

#create table
${CMD_MYSQL} < ${CREATE_BOND}
echo "create BOND table"

#insert data
${CMD_MYSQL} -e "LOAD DATA LOCAL INFILE '${INSERT_BOND}' INTO TABLE testDB.BOND FIELDS TERMINATED BY ','"
echo "insert BOND data"

