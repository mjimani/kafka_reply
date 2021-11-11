#while [ $# -gt 0 ]; do
#	if [[ $1 == *"--"* ]]; then
#		v="${1/--/}"
#		declare $v="$2"
#	fi
#	shift
#done

protoc --java_out=. addressbook.proto
