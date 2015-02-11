DESCRIPTION = "Patient Monitor Demo"

HOMEPAGE = "http://www.mentor.com/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

DEPENDS = "qtbase"
RECOMMENDS = "lighttpd"

SRC_URI = "git://github.com/hyei/pmd-demo;branch=imx6_solox/uamp"
SRCREV = "b78769963fea221f0a637f6dfbb7641ef252f596"
SRC_URI += "file://pmd.desktop \
    file://index.html \
    file://screen-dump.png \
    file://Xsession_pmd_autostart \
"

S = "${WORKDIR}/git"

# Uncomment below to work with zip archive dropped inside layer
#SRC_URI = "file://PatientMonitorDemo.zip"
#S = "${WORKDIR}/PatientMonitorDemo"



inherit qmake5

# Set path of qt5 headers as qmake5_base.bbclass sets this to just ${includedir} but
# actually it is ${includedir}/qt5
OE_QMAKE_PATH_HEADERS = "${OE_QMAKE_PATH_QT_HEADERS}"

FILES_${PN}-dbg += "${OE_QMAKE_PATH_EXAMPLES}/HAMPDemo/PatientMonitorDemo/.debug"
FILES_${PN} += "${OE_QMAKE_PATH_EXAMPLES} \
    /www/pages/ \
    /home/root \
"

do_install_append () {
        install -d -m 755 ${D}/${datadir}/applications
        install -m 644 ${WORKDIR}/pmd.desktop ${D}/${datadir}/applications/pmd.desktop
        install -d -m 755 ${D}/www/pages/
        install -d -m 755 ${D}/home/root/
        install -m 644 ${WORKDIR}/index.html ${D}/www/pages/index.html
        install -m 644 ${WORKDIR}/screen-dump.png ${D}/www/pages/screen-dump.png
        install -m 755 ${WORKDIR}/Xsession_pmd_autostart ${D}/home/root/.Xsession
}
