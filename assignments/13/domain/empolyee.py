class Empolyee(object):
    def __init__(self, name, en, team, project, position):
        self.name = name
        self.en = en
        self.team = team
        self.project = project
        self.position = position

    def __repr__(self):
        return "<Empolyee(name= %s, projectId = %d) >" %(self.name, self.project_id)
