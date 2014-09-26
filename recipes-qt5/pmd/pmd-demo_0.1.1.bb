DESCRIPTION = "Patient Monitor Demo"

HOMEPAGE = "http://www.mentor.com/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

DEPENDS = "qtbase"

#SRC_URI = "file://PatientMonitorDemo.zip"
SRC_URI = "git://github.com/challinan/pmd-demo;branch=exp-12801024"
# 30476778 is the baseline, be977207 is the new 1280x1024 experiment
#SRCREV = "30476778e1682458339bdb5fdd494ed9cd67ad98"
SRCREV = "be9772076359924dea677d421ce315bd4aa33abb"

S = "${WORKDIR}/git"

inherit qmake5

# Set path of qt5 headers as qmake5_base.bbclass sets this to just ${includedir} but
# actually it is ${includedir}/qt5
OE_QMAKE_PATH_HEADERS = "${OE_QMAKE_PATH_QT_HEADERS}"

FILES_${PN}-dbg += "${OE_QMAKE_PATH_EXAMPLES}/HAMPDemo/PatientMonitorDemo/.debug"
FILES_${PN} += "${OE_QMAKE_PATH_EXAMPLES}"

