
do_install_append () {
	echo "INPUT_EXTRA_ARGS=-nocursor" >> ${D}${sysconfdir}/default/xserver-nodm
}

