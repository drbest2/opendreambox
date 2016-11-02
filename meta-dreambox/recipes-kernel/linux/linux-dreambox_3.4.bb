PATCHREV = "a904cb737a1d95034adc4717200cdf1e52ec8549"
PATCHLEVEL = "110"

SRC_URI = " \
    ${KERNELORG_MIRROR}/linux/kernel/v3.x/linux-3.4.tar.xz;name=kernel \
    ${KERNELORG_MIRROR}/linux/kernel/v3.x/patch-3.4.${PATCHLEVEL}.xz;apply=yes;name=stable-patch \
    http://dreamboxupdate.com/download/kernel-patches/linux-dreambox-${PV}-${PATCHREV}.patch.xz;apply=yes;name=dream-patch \
    file://0001-xhci-Return-correct-number-of-tranferred-bytes-for-s.patch \
    file://0002-xhci-fix-off-by-one-error-in-TRB-DMA-address-boundar.patch \
    file://0003-MIPS-Fix-build-with-binutils-2.24.51.patch \
    file://0004-staging-rtl8712-rtl8712-avoid-lots-of-build-warnings.patch \
    file://0005-nfs-fail-early-on-nfsvers-4.1.patch \
"
SRC_URI[kernel.md5sum] = "967f72983655e2479f951195953e8480"
SRC_URI[kernel.sha256sum] = "ff3dee6a855873d12487a6f4070ec2f7996d073019171361c955639664baa0c6"
SRC_URI[stable-patch.md5sum] = "4225d2f3a2bdd2d2fed94b5b83a5a8bb"
SRC_URI[stable-patch.sha256sum] = "132362637b7ba272d58acbedb172a7233c238ec1d794af111af55ee8a406e12d"
SRC_URI[dream-patch.md5sum] = "81d8689bc16214cd1737e029d39bb46c"
SRC_URI[dream-patch.sha256sum] = "4e4d40bc4ea6d1425348c6a01aad637686da835378ef78896e89686c38884d44"

require linux-dreambox.inc

S = "${WORKDIR}/linux-3.4"

CMDLINE = "bmem=512M@512M memc1=768M console=ttyS0,1000000 root=/dev/mmcblk0p1 rootwait rootfstype=ext4"

COMPATIBLE_MACHINE = "^(bcm7435)$"

DEFCONFIG = "${MACHINE}"

BRCM_PATCHLEVEL = "3.5"

LINUX_VERSION = "3.4-${BRCM_PATCHLEVEL}-${MACHINE}"
KERNEL_IMAGETYPE = "vmlinux.bin"
KERNEL_IMAGETYPES = "vmlinux.gz"
