#!/bin/bash

PWD=`pwd`

while getopts ':hd:' option; do
	case "${option}" in
		d) PWD=$OPTARG
		   ;;
		h) echo "USAGE: ./install_nfv_sol_libs.sh [-d DIR_LIBS]"
		   echo "       DIR_LIBS: Directory where libs are stored. In case parameter is missing, DIR_LIBS=PWD"
		   exit
		   ;;
	esac
done



DIR_LIBS=${PWD}

DIR_LIBS_COMMON=NFV_MANO_LIBS_COMMON/
DIR_LIBS_DESC=NFV_MANO_LIBS_DESCRIPTORS/

mvn_install() {
	cd "$1"
	mvn clean install
	if [ "$?" -ne 0 ]; then
		echo "Failed $2 installation!"
		exit 1
	else
		echo "Installed $2"
	fi
}

echo "Starting installation"

cd $DIR_LIBS

mvn_install_doc $DIR_LIBS_COMMON "NFV libs common"
cd ..
mvn_install_doc $DIR_LIBS_DESC "NFV libs descriptors"
cd ..

echo "All NFV SOL libs installed!"

exit #
