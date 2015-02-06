DESCRIPTION = "Patient Monitor Demo"

HOMEPAGE = "http://www.mentor.com/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

DEPENDS = "qtbase"

SRC_URI = "git://github.com/hyei/pmd-demo;branch=imx6_solox/uamp"
SRCREV = "d6f8bc3de091577428476e480abdda8f313e7f24"
SRC_URI += "file://pmd.desktop"

S = "${WORKDIR}/git"

# Uncomment below to work with zip archive dropped inside layer
#SRC_URI = "file://PatientMonitorDemo.zip"
#S = "${WORKDIR}/PatientMonitorDemo"



inherit qmake5

# Set path of qt5 headers as qmake5_base.bbclass sets this to just ${includedir} but
# actually it is ${includedir}/qt5
OE_QMAKE_PATH_HEADERS = "${OE_QMAKE_PATH_QT_HEADERS}"

FILES_${PN}-dbg += "${OE_QMAKE_PATH_EXAMPLES}/HAMPDemo/PatientMonitorDemo/.debug"
FILES_${PN} += "${OE_QMAKE_PATH_EXAMPLES}"

do_install_append () {
        install -d -m 755 ${D}/${datadir}/applications
        install -m 644 ${WORKDIR}/pmd.desktop ${D}/${datadir}/applications/pmd.desktop
}
