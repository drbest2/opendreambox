SUMMARY = "satip client using vtuner"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"

GITHUB_BRANCH = "next"
SRC_URI += " \
    file://satip-client.service \
"

SRCREV = "de95c81d97676b849871935a403136abc3fc2a73"

inherit autotools pkgconfig opendreambox-github systemd

SYSTEMD_SERVICE_${PN} = "satip-client.service"

do_install_append() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/satip-client.service ${D}${systemd_unitdir}/system/
}

CONFFILES_${PN} = "${sysconfdir}/vtuner.conf"

EXTRA_OECONF = " \
    --with-boxtype=${MACHINE} \
"
