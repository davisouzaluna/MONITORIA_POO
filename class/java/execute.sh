#!/bin/bash

if [ -z "$1" ]; then
    echo "Uso: ./executar.sh NomeDaClasse"
    exit 1
fi

ARQUIVO="$1.java"
CLASSE="$1"

if [ ! -f "$ARQUIVO" ]; then
    echo "Arquivo $ARQUIVO não encontrado no diretório atual."
    exit 1
fi

javac "$ARQUIVO"
if [ $? -ne 0 ]; then
    echo "Erro ao compilar $ARQUIVO."
    exit 1
fi

java "$CLASSE"
