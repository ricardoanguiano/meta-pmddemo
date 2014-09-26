DESCRIPTION = "Mentor Graphics QT5 washing machine demo application"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "git://github.com/MentorEmbedded/qt-demos.git;branch=master"
SRCREV = "${AUTOREV}"

DEPENDS = "qtbase qtwebkit qtdeclarative"
RDEPENDS_${PN} = "qtbase qtwebkit qtdeclarative"

S = "${WORKDIR}/git/WashingMachineDemo"

FILES_${PN} += " \
     ${D}${bindir}/WashingMachineDemo \
     ${D}${bindir}/WashingMachineDemo.sh \
"

do_install_append () {
    install -m 0755 -d ${D}${bindir}

    install -m 0755 ${B}/WashingMachineDemo ${D}${bindir}/WashingMachineDemo
    install -m 0755 ${WORKDIR}/git/scripts/WashingMachineDemo.sh ${D}${bindir}/WashingMachineDemo.sh
}

inherit qmake5
