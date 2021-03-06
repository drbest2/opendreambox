SUMMARY = "enigma2 default services/transponder"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${OPENDREAMBOX_BASE}/LICENSE;md5=8f242b441da515e30c7b07f2cc6f4d5c"

SRC_URI = " \
	file://lamedb.192 file://lamedb.130 file://lamedb.282 \
	file://sat192.info file://sat130.info file://sat282.info \
"

S = "${WORKDIR}"

inherit allarch

do_install() {
        install -d ${D}/usr/share/enigma2/dealer
        install ${WORKDIR}/*.info ${D}/usr/share/enigma2/dealer
        install ${WORKDIR}/lamedb.* ${D}/usr/share/enigma2/dealer
}

FILES_${PN} = "/"
