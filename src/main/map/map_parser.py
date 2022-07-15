import os

dir = os.getcwd()

dir += "\\..\\..\\res\\maps\\tiledfiles"

for file in os.listdir(dir):

    final_str = ""

    if ".tmx" in file:

        with open(dir + "\\" + file, "r") as f:

            lines = f.read().splitlines()

            for line in lines:

                if "<" not in line:

                    final_str += line + "\n"

        with open(dir + "\\" + file.replace("tmx", "txt"), "a+") as outf:

            outf.seek(0)
            outf.truncate()
            outf.seek(0)
            outf.write(final_str)

