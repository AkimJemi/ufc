REPOSITORY=$1
TARGET=$2
PARAM1=$3

ufc=(language linux git)
declare -A git_info=(
  ["ufc"]="${ufc[@]}"
  ["LeetCode_JEMIN"]="java"
)



git add .
git commit -m "echo $(date +'%Y/%m/%d %H:%M:%S')"
git push origin main


