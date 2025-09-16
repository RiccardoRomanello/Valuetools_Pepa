import argparse

def generate_model(num_miners: int, outfile: str = "model.txt"):
    lines = []
    lines.append("set_default_level low;\n")
    lines.append("high h;\n")

    terms = [f"(m{i+1},0.5).P{i+1}" for i in range(num_miners)]
    terms.append("(h, 0.1).P{}".format(num_miners + 1))
    P0_line = "P0 = " + " + ".join(terms) + ";"
    lines.append("\n// {} fair miners + h transition\n".format(num_miners))
    lines.append(P0_line + "\n")

    for i in range(num_miners):
        lines.append(f"P{i+1} = (v{i+1},0.3).P0 + (m{i+1},0.5).P{i+1};")
    lines.append("")

    fair_second_block = num_miners - 1
    unfair_start = num_miners + 1

    lines.append(f"// Second block: {fair_second_block} fair miners, 1 unfair")

    terms = ["(mu,0.5).P{}".format(unfair_start + 1)]
    for i in range(fair_second_block):
        terms.append(f"(m{i+1},0.5).P{unfair_start + 2 + i}")
    lines.append("P{} = ".format(unfair_start) + " + ".join(terms) + ";")

    lines.append(f"P{unfair_start+1} = (vu,0.3).P{unfair_start} + (mu,0.5).P{unfair_start+1};")

    for i in range(fair_second_block):
        lines.append(
            f"P{unfair_start+2+i} = (v{i+1},0.3).P{unfair_start} + (mu,0.5).P{unfair_start+1} + (m{i+1},0.5).P{unfair_start+2+i};"
        )
    lines.append("")

    lines.append("\nP0")

    with open(outfile, "w") as f:
        f.write("\n".join(lines))

    print(f"Model written to {outfile}")


def main():
    parser = argparse.ArgumentParser(description="Generate miner process model.")
    parser.add_argument("num_miners", type=int, help="Number of miners (all fair in the first block, 1 unfair in the second)")
    parser.add_argument("-o", "--outfile", type=str, default="model.txt", help="Output file name")

    args = parser.parse_args()
    if args.num_miners < 2:
        raise ValueError("Number of miners must be at least 2 (to allow 1 unfair in second block)")
    generate_model(args.num_miners, args.outfile)


if __name__ == "__main__":
    main()