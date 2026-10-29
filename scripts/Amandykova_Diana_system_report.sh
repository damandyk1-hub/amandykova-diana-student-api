#!/bin/bash
# System report script - Amandykova Diana

LOG="$(dirname "$0")/../logs/Amandykova_Diana_system_report.log"

{
echo "========== SYSTEM REPORT =========="
echo "Student: Amandykova Diana"
echo "Date and time: $(date)"
echo "User: $(whoami)"
echo ""
echo "--- OS and kernel ---"
uname -a
echo ""
echo "--- CPU ---"
echo "CPU: $(sysctl -n machdep.cpu.brand_string)"
echo "CPU cores: $(sysctl -n hw.ncpu)"
echo ""
echo "--- Memory ---"
echo "Total memory: $(( $(sysctl -n hw.memsize) / 1024 / 1024 / 1024 )) GB"
vm_stat | head -5
echo ""
echo "--- Disk usage ---"
df -h
echo ""
echo "--- Available disk space on / ---"
df -h / | awk 'NR==2 {print $4}'
echo "==================================="
echo ""
} | tee -a "$LOG"

echo "Report saved to $LOG"
