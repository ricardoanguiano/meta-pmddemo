FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://xorg-calibration.txt"
do_install () {
	if test -s ${WORKDIR}/xorg.conf; then
		cat ${WORKDIR}/xorg-calibration.txt
		cat ${WORKDIR}/xorg-calibration.txt >> ${WORKDIR}/xorg.conf
		install -d ${D}/${sysconfdir}/X11
 		install -m 0644 ${WORKDIR}/xorg.conf ${D}/${sysconfdir}/X11/
	fi

}
