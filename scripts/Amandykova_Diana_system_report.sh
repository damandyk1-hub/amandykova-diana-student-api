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
lscpu | grep "Model name"
echo "CPU cores: $(nproc)"
echo ""
echo "--- Memory ---"
free -h
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
