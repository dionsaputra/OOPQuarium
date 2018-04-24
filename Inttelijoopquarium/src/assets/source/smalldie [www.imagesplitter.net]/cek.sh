if ! test -x /usr/bin/qmake
then
  # The Qt library is missing...
  echo "error: This script requires Qt to be installed."
  exit 1
fi

# The Qt library is installed
...do your thing...
